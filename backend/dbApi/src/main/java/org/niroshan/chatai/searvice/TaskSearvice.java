package searvice;

import model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.TaskRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TaskSearvice {

    @Autowired
    private TaskRepository taskRepository;

    // Implement basic CRUD Operations for task

    public List<Task> getAllTasks(String userId) {
        return taskRepository.findByUserId(userId);
    }
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }
    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }
    public Task updateTask(String id, Task Updatedtask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(Updatedtask.getTitle());
            task.setDescription(Updatedtask.getDescription());
            task.setPriority(Updatedtask.getPriority());
            task.setStatus(Updatedtask.getStatus());
            task.setDueDate(Updatedtask.getDueDate());
            return taskRepository.save(task);
        }).orElse(null);
    }
    public void deleteTask(String id){
        taskRepository.deleteById(id);
    }
}
