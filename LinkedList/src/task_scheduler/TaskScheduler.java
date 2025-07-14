package task_scheduler;

class TaskScheduler {
    private Task head = null;
    private Task current = null;

    // Add at beginning
    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        Task newTask = new Task(id, name, priority, dueDate);

        if (head == null) {
            head = newTask;
            head.next = head;
            current = head;
        } else {
            Task last = head;
            while (last.next != head) {
                last = last.next;
            }
            newTask.next = head;
            last.next = newTask;
            head = newTask;
        }
    }

    // Add at end
    public void addAtEnd(int id, String name, int priority, String dueDate) {
        if (head == null) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task last = head;
        while (last.next != head) {
            last = last.next;
        }
        last.next = newTask;
        newTask.next = head;
    }

    // Add at specific position (1-based)
    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos <= 1 || head == null) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        Task newTask = new Task(id, name, priority, dueDate);
        Task temp = head;
        int count = 1;

        while (count < pos - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;
    }

    // Remove task by ID
    public void removeById(int id) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Task curr = head, prev = null;

        do {
            if (curr.id == id) {
                if (curr == head) {
                    Task last = head;
                    while (last.next != head) {
                        last = last.next;
                    }

                    if (head == head.next) { // Only one node
                        head = null;
                        current = null;
                    } else {
                        head = head.next;
                        last.next = head;
                    }
                } else {
                    prev.next = curr.next;
                }

                if (current == curr)
                    current = head;

                System.out.println("Task with ID " + id + " removed.");
                return;
            }
            prev = curr;
            curr = curr.next;
        } while (curr != head);

        System.out.println("Task not found.");
    }

    // View current task
    public void viewCurrentTask() {
        if (current == null) {
            System.out.println("No tasks scheduled.");
            return;
        }

        System.out.println("Current Task → ID: " + current.id + ", Name: " + current.name +
                ", Priority: " + current.priority + ", Due: " + current.dueDate);
    }

    // Move to next task
    public void moveToNextTask() {
        if (current != null) {
            current = current.next;
            System.out.println("Moved to next task.");
        }
    }

    // Display all tasks from head
    public void displayAllTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task temp = head;
        System.out.println("\n--- All Tasks ---");
        do {
            System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Priority: " + temp.priority + ", Due: " + temp.dueDate);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        Task temp = head;
        boolean found = false;
        System.out.println("Tasks with priority " + priority + ":");

        do {
            if (temp.priority == priority) {
                System.out.println("ID: " + temp.id + ", Name: " + temp.name + ", Due: " + temp.dueDate);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found)
            System.out.println("No tasks found with priority " + priority);
    }
}
