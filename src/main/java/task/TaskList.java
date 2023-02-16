package task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TaskList implements Serializable {

    // For serialization
    private static final long serialVersionUID = (1 << 4);

    private final List<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task addedTask) {
        tasks.add(addedTask);
    }

    public Task removeTask(int taskId) {
        return tasks.remove(taskId);
    }

    public Task getTask(int taskId) {
        return tasks.get(taskId);
    }

    public int getTaskCount() {
        return tasks.size();
    }

    public TaskList findDescription(String keyword) {
        List<Task> filteredTasks = tasks
                .stream()
                .filter(task -> task.description.contains(keyword))
                .collect(Collectors.toList());

        return new TaskList(filteredTasks);
    }

}
