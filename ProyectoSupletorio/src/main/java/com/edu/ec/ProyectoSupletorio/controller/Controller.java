package com.edu.ec.ProyectoSupletorio.controller;
import com.edu.ec.ProyectoSupletorio.Service.TaskService;
import com.edu.ec.ProyectoSupletorio.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/api/tasks")
    public class Controller {

        @Autowired
        private TaskService taskService;

        @GetMapping
        public List<Task> getAllTasks() {
            return taskService.getAllTasks();
        }

        @GetMapping("/{id}")
        public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
            Optional<Task> task = taskService.getTaskById(id);
            return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        }

        @PostMapping
        public ResponseEntity<Task> createTask(@RequestBody Task task) {
            Task savedTask = taskService.saveTask(task);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
        }

        @PutMapping("/{id}")
        public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
            try {
                Task updatedTask = taskService.updateTask(id, task);
                return ResponseEntity.ok(updatedTask);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.notFound().build();
            }

        }

        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteTask(@PathVariable Long id) {
            try {
                taskService.deleteTask(id);
                return ResponseEntity.noContent().build();
            } catch (IllegalArgumentException e) {
                return ResponseEntity.notFound().build();
            }
        }

        @GetMapping("/status/{completed}")
        public List<Task> getTasksByStatus(@PathVariable boolean completed) {
            return taskService.getTasksByStatus(completed);
        }
    }

