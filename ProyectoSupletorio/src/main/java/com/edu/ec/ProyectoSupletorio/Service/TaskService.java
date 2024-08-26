package com.edu.ec.ProyectoSupletorio.Service;
import com.edu.ec.ProyectoSupletorio.Repository.TaskRepository;
import com.edu.ec.ProyectoSupletorio.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
    public class TaskService {

        @Autowired
        private TaskRepository taskRepository;

        public List<Task> getAllTasks() {
            List<Task> resultado = taskRepository.findAll();
            resultado.forEach(task -> System.out.println(task.toString()));
            return resultado;

        }

        public Optional<Task> getTaskById(Long id) {
            return taskRepository.findById(id);
        }

        public Task saveTask(Task task) {
            task.setCreationDate(LocalDateTime.now()); // Set default creation date
            return taskRepository.save(task);
        }

    public Task updateTask(Long id, Task newTask) {
        return taskRepository.findById(id).map(task -> {
            task.setTitle(newTask.getTitle());
            task.setDescription(newTask.getDescription());
            task.setState(newTask.isState());
            return taskRepository.save(task);
        }).orElseThrow(() -> new RuntimeException("Task not found"));
    }


        public void deleteTask(Long id) {
            taskRepository.deleteById(id);
        }
// devuelve la tarea por estados
        public List<Task> getTasksByStatus(boolean state) {
            List<Task> resultado = taskRepository.findByState(state);
            resultado.stream().filter(task -> state==task.isState()).collect(Collectors.toList());
            resultado.forEach(task -> System.out.println(task.toString()));
            return resultado;
        }


}
