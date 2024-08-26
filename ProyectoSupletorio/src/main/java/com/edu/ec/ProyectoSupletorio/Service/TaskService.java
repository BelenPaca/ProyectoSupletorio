package com.edu.ec.ProyectoSupletorio.Service;
import com.edu.ec.ProyectoSupletorio.Repository.TaskRepository;
import com.edu.ec.ProyectoSupletorio.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

    @Service
    public class TaskService {

        @Autowired
        private TaskRepository taskRepository;

        public List<Task> getAllTasks() {
            return taskRepository.findAll();
        }

        public Optional<Task> getTaskById(Long id) {
            return taskRepository.findById(id);
        }

        public Task saveTask(Task task) {
            task.setCreationDate(LocalDateTime.now()); // Set default creation date
            return taskRepository.save(task);
        }

        public Task updateTask(Long id, Task task) {
            if (!taskRepository.existsById(id)) {
                throw new IllegalArgumentException("Task not found");
            }
            task.setId(id);
            return taskRepository.save(task);
        }

        public void deleteTask(Long id) {
            if (!taskRepository.existsById(id)) {
                throw new IllegalArgumentException("Task not found");
            }
            taskRepository.deleteById(id);
        }

        public List<Task> getTasksByStatus(boolean completed) {
            return taskRepository.findByCompleted(completed);
        }
}
