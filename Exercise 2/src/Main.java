import models.Task;
import services.ScheduleManager;
import services.TaskFactory;
import observers.TaskObserver;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ScheduleManager manager = ScheduleManager.getInstance();
        TaskObserver observer = new TaskObserver();
        manager.addObserver(observer);
        TaskFactory factory = new TaskFactory();
        Scanner scanner = new Scanner(System.in);

        // Display available commands
        displayCommands();

        while (true) {
            System.out.println("Enter command (type 'Exit' to quit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("Exit")) {
                break;
            }

            try {
                processInput(input, manager, factory);
            } catch (Exception e) {
                System.out.println("\n Error: " + e.getMessage() + "\n");
            }
        }

        scanner.close();
    }

    private static void displayCommands() {
        System.out.println("Available Commands:");
        System.out.println("1. Add Task: Add Task(\"Description\", \"Start Time\", \"End Time\", \"Priority\")");
        System.out.println("2. View Tasks: View Tasks");
        System.out.println("3. Remove Task: Remove Task(\"Description\")");
        System.out.println("4. Edit Task: Edit Task(\"Description\", \"New Start Time\", \"New End Time\", \"New Priority\")");
        System.out.println("5. Finish Task: Finish Task(\"Description\")");
        System.out.println("6. View Tasks by Priority: View Tasks by Priority(\"Priority Level\")");
        System.out.println("7. Exit: Exit");
        System.out.println("Note: Ensure time is in HH:mm format and use quotes for descriptions and priorities.");
        System.out.println();
    }

    private static void processInput(String input, ScheduleManager manager, TaskFactory factory) {
        String command;
        String[] parts;
    
        int commandEndIndex = input.indexOf("(");
        
        if (commandEndIndex == -1) {
            command = input.trim(); 
        } else {
            command = input.substring(0, commandEndIndex).trim();
        }
    
        if (commandEndIndex != -1) {
            String params = input.substring(commandEndIndex + 1, input.length() - 1); 
            parts = params.split(",\\s*");
        } else {
            parts = new String[0]; 
        }
    
        switch (command) {
            case "Add Task":
                if (parts.length != 4) {
                    throw new IllegalArgumentException("Invalid format. Use: Add Task(\"Description\", \"Start Time\", \"End Time\", \"Priority\")");
                }
                String description = parts[0].replaceAll("\"", "").trim();
                LocalTime startTime;
                LocalTime endTime;
                try {
                    startTime = LocalTime.parse(parts[1].replaceAll("\"", "").trim());
                    endTime = LocalTime.parse(parts[2].replaceAll("\"", "").trim());
                } catch (DateTimeParseException e) {
                    throw new IllegalArgumentException("Invalid time format.");
                }
                String priority = parts[3].replaceAll("\"", "").trim();
    
                if (endTime.isBefore(startTime)) {
                    throw new IllegalArgumentException("End time must be after start time.");
                }
    
                Task newTask = factory.createTask(description, startTime, endTime, priority);
                manager.addTask(newTask);
                break;
    
            case "View Tasks":
                var tasks = manager.getTasks();
                if (tasks.isEmpty()) {
                    System.out.println("\n No tasks scheduled for the day. \n");
                } else {
                    for (Task task : tasks) {
                        System.out.println(task);
                    }
                }
                break;
    
            case "Remove Task":
                if (parts.length != 1) {
                    throw new IllegalArgumentException("Invalid format. Use: Remove Task(\"Description\")");
                }
                String removeDescription = parts[0].replaceAll("\"", "").trim();
                boolean removed = manager.removeTask(removeDescription);
                System.out.println(removed ? "\n Task removed successfully. \n" : "\n Error: Task not found. \n");
                break;
    
            case "Edit Task":
                if (parts.length != 4) {
                    throw new IllegalArgumentException("Invalid format. Use: Edit Task(\"Description\", \"New Start Time\", \"New End Time\", \"New Priority\")");
                }
                String editDescription = parts[0].replaceAll("\"", "").trim();
                LocalTime newStartTime;
                LocalTime newEndTime;

                try {
                    newStartTime = LocalTime.parse(parts[1].replaceAll("\"", "").trim());
                    newEndTime = LocalTime.parse(parts[2].replaceAll("\"", "").trim());
                } catch (DateTimeParseException e) {
                    throw new IllegalArgumentException("Invalid time format.");
                }

                String newPriority = parts[3].replaceAll("\"", "").trim();
    
                boolean edited = manager.editTask(editDescription, newStartTime, newEndTime, newPriority);
                if(edited){
                    System.out.println("\n Task edited successfully. \n");
                }
                break;
    
            case "Finish Task":
                if (parts.length != 1) {
                    throw new IllegalArgumentException("Invalid format. Use: Finish Task(\"Description\")");
                }
                String finishDescription = parts[0].replaceAll("\"", "").trim();
                try {
                    manager.markTaskCompleted(finishDescription);
                    System.out.println("\n Task marked as completed successfully. \n");
                } catch (Exception e) {
                    System.out.println("\n Error: " + e.getMessage() + "\n");
                }
                break;
    
            case "View Tasks by Priority":
                if (parts.length != 1) {
                    throw new IllegalArgumentException("Invalid format. Use: View Tasks by Priority(\"Priority Level\")");
                }
                String taskPriority = parts[0].replaceAll("\"", "").trim();
                var priorityTasks = manager.getTasksByPriority(taskPriority);
                if (priorityTasks.isEmpty()) {
                    System.out.println("\n No tasks found with priority: " + taskPriority + "\n");
                } else {
                    for (Task task : priorityTasks) {
                        System.out.println(task);
                    }
                }
                break;
    
            default:
                throw new IllegalArgumentException("Invalid command. Use: Add Task(...), Remove Task(...), Edit Task(...), Finish Task(...), View Tasks, or View Tasks by Priority(...).");
        }
    }
}