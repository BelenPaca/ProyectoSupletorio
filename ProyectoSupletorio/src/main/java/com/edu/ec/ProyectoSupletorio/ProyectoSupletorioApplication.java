package com.edu.ec.ProyectoSupletorio;

import com.edu.ec.ProyectoSupletorio.Service.TaskService;
import com.edu.ec.ProyectoSupletorio.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;

// Examen Supletorio Programación Avanzada II
// Nombre: Belén Paca

@SpringBootApplication
public class ProyectoSupletorioApplication implements CommandLineRunner{
	@Override
	public void run(String... args) throws Exception {
		System.out.println("=======================================");
		System.out.println("Aplicación ToDoList iniciada");
		System.out.println("=======================================");

		Task task = new Task();
		task.setTitle("Programar");
		task.setDescription("Supletorio Programacion");
		task.setState(true);
		task.setCreationDate(LocalDateTime.now());
		taskService.saveTask(task);

		Task t = new Task();
		t.setTitle("Matematica");
		t.setDescription("Supletorio Programacion");
		t.setState(false);
		t.setCreationDate(LocalDateTime.now());
		taskService.saveTask(t);
//		taskService.updateTask(2L, t);
//		taskService.deleteTask(2L);

		Task task2 = new Task();
		task2.setTitle("Emprendimiento");
		task2.setDescription("Supletorio");
		task2.setState(false);
		task2.setCreationDate(LocalDateTime.now());
		taskService.saveTask(task2);
		taskService.getTasksByStatus(true);

//		taskService.getAllTasks();
	}
	@Autowired
	private TaskService taskService;

	public static void main(String[] args) {
		SpringApplication.run(ProyectoSupletorioApplication.class, args);
	}

};

