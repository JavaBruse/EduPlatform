package ru.javabruse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javabruse.entities.Lesson;

import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByCourseModuleId(Long courseModuleId);
}
