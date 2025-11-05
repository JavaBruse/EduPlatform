package ru.javabruse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javabruse.entities.Course;
import ru.javabruse.repositories.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> findById(Long id) {
        return courseRepository.findById(id);
    }

    public List<Course> findByTeacherId(Long teacherId) {
        return courseRepository.findByTeacherId(teacherId);
    }

    public List<Course> findByCategoryId(Long categoryId) {
        return courseRepository.findByCategoryId(categoryId);
    }

    public List<Course> findByCategoryName(String categoryName) {
        return courseRepository.findByCategory_Name(categoryName);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }

    public void deleteById(Long id) {
        courseRepository.deleteById(id);
    }
}