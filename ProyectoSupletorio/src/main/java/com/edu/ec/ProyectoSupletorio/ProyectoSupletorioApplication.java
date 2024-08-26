package com.edu.ec.ProyectoSupletorio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

// Examen Supletorio Programación Avanzada II
// Nombre: Belén Paca

@SpringBootApplication
public class ProyectoSupletorioApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoSupletorioApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			// Mensajes de inicio
			System.out.println("=======================================");
			System.out.println("Aplicación ToDoList iniciada");
			System.out.println("=======================================");

			// Aquí puedes agregar información sobre las acciones disponibles
			System.out.println("Acciones disponibles:");
			System.out.println("1. Crear una tarea: POST /api/tasks");
			System.out.println("2. Obtener todas las tareas: GET /api/tasks");
			System.out.println("3. Obtener una tarea por ID: GET /api/tasks/{id}");
			System.out.println("4. Actualizar una tarea: PUT /api/tasks/{id}");
			System.out.println("5. Eliminar una tarea: DELETE /api/tasks/{id}");
			System.out.println("6. Listar tareas por estado (completadas o pendientes): GET /api/tasks/status/{completed}");
			System.out.println("=======================================");
		};
	}
}
