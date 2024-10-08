package com.edu.ec.ProyectoSupletorio.Repository;
import com.edu.ec.ProyectoSupletorio.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

    public interface TaskRepository extends JpaRepository<Task, Long> {
        List<Task> findByState(boolean state);
}
