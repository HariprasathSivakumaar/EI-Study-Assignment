package observers;

import models.Task;

public interface ITaskObserver {
    void notify(Task conflictingTask);
}