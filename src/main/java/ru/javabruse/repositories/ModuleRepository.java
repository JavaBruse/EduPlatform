package ru.javabruse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javabruse.entities.CourseModule;

import java.util.List;

public interface ModuleRepository extends JpaRepository<CourseModule, Long> {
    List<CourseModule> findByCourseId(Long courseId);
}

