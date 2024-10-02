package observers;

import models.Task;

public class TaskObserver implements ITaskObserver {
    @Override
    public void notify(Task conflictingTask) {
        System.out.println("\n Error: Task conflicts with existing task \"" + conflictingTask.getDescription() + "\". \n");
    }
}
