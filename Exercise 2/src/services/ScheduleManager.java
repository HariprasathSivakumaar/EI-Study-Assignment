package services;

import models.Task;
import observers.ITaskObserver;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;
    private List<ITaskObserver> observers;

    private ScheduleManager() {
        tasks = new ArrayList<>();
        observers = new ArrayList<>();
    }

    public static ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addObserver(ITaskObserver observer) {
        observers.add(observer);
    }

    public void addTask(Task task) {
        Task conflictingTask = findConflictingTask(task);
        if (conflictingTask != null) {
            notifyObservers(conflictingTask); 
            return; 
        }
        tasks.add(task);
        System.out.println("\n Task added successfully. No conflicts.\n"); 
    }
    
    private Task findConflictingTask(Task newTask) {
        for (Task task : tasks) {
            if (newTask.getStartTime().isBefore(task.getEndTime()) && newTask.getEndTime().isAfter(task.getStartTime())) {
                return task; 
            }
        }
        return null; 
    }
    
    private void notifyObservers(Task conflictingTask) {
        for (ITaskObserver observer : observers) {
            observer.notify(conflictingTask);
        }
    }

    public List<Task> getTasks() {
        tasks.sort((t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()));
        return tasks;
    }

    public boolean removeTask(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                tasks.remove(task);
                return true;
            }
        }
        return false;
    }
    
    public boolean editTask(String description, LocalTime newStartTime, LocalTime newEndTime, String newPriority) {
        Task taskToEdit = null;
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                taskToEdit = task;
                break;
            }
        }
    
        if (taskToEdit == null) {
            throw new IllegalArgumentException("Task not found."); 
        }

        
        Task tempTask = new Task(description, newStartTime, newEndTime, newPriority);
        
        Task conflictingTask = findConflictingTask(tempTask);
        if (conflictingTask != null && !conflictingTask.equals(taskToEdit)) {
            notifyObservers(conflictingTask); 
            return false; 
        }
    
        taskToEdit.setStartTime(newStartTime);
        taskToEdit.setEndTime(newEndTime);
        taskToEdit.setPriority(newPriority);
        return true; 
    }

    public void markTaskCompleted(String description) {
        for (Task task : tasks) {
            if (task.getDescription().equalsIgnoreCase(description)) {
                task.markCompleted();
                return;
            }
        }
        throw new IllegalArgumentException("\n Task not found. \n");
    }

    public List<Task> getTasksByPriority(String priority) {
        return tasks.stream()
                .filter(task -> task.getPriority().equalsIgnoreCase(priority))
                .sorted((t1, t2) -> t1.getStartTime().compareTo(t2.getStartTime()))
                .collect(Collectors.toList());
    }
}
