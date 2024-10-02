# Astronaut Daily Schedule Organizer

This console-based application helps astronauts organize their daily schedules by allowing users to add, remove, view, edit, and mark tasks as completed. Each task includes a description, start time, end time, and priority level. The application implements various design patterns, including Singleton, Factory, and Observer patterns to maintain clean architecture.

## Features

- **Add Task**: Create a new task with a description, start time, end time, and priority level.
- **Remove Task**: Delete an existing task based on its description.
- **View Tasks**: Display all scheduled tasks sorted by their start time.
- **Edit Task**: Modify an existing task's details.
- **Finish Task**: Mark a task as completed.
- **View Tasks by Priority**: Filter tasks based on their priority level.

## Commands

The following commands are available for user interaction:

1. **Add Task**: `Add Task("Description", "Start Time", "End Time", "Priority")`
2. **View Tasks**: `View Tasks`
3. **Remove Task**: `Remove Task("Description")`
4. **Edit Task**: `Edit Task("Description", "New Start Time", "New End Time", "New Priority")`
5. **Finish Task**: `Finish Task("Description")`
6. **View Tasks by Priority**: `View Tasks by Priority("Priority Level")`
7. **Exit**: `Exit`

## Design Patterns Used

1. Singleton Pattern: Ensures only one instance of ScheduleManager exists.
2. Factory Pattern: The TaskFactory class is used to create Task objects.
3. Observer Pattern: Notifies users of task conflicts or updates via the TaskObserver.

## How to run:

1. Clone the repository:
   ```bash
   git clone https://github.com/HariprasathSivakumaar/EI-Study-Assignment.git
   ```
2. Change Directory:
   ```bash
   cd EI-Study-Assignment\Exercise 2\src
   ```
3. Run:
   ```bash
   java Main
   ```
