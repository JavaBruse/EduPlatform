package ru.javabruse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javabruse.entities.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findByTeacherId(Long teacherId);
    List<Course> findByCategoryId(Long categoryId);
    List<Course> findByCategory_Name(String categoryName);
}

