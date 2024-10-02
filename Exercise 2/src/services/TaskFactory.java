package services;

import models.Task;

import java.time.LocalTime;

public class TaskFactory {
    public Task createTask(String description, LocalTime startTime, LocalTime endTime, String priority) {
        return new Task(description, startTime, endTime, priority);
    }
}
