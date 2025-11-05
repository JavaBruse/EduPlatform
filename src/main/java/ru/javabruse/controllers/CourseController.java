package ru.javabruse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javabruse.entities.Course;
import ru.javabruse.services.CourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/courses")
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping
    public List<Course> getAllCourses() {
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        Optional<Course> course = courseService.findById(id);
        return course.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/teacher/{teacherId}")
    public List<Course> getCoursesByTeacher(@PathVariable Long teacherId) {
        return courseService.findByTeacherId(teacherId);
    }

    @GetMapping("/category/{categoryId}")
    public List<Course> getCoursesByCategoryId(@PathVariable Long categoryId) {
        return courseService.findByCategoryId(categoryId);
    }

    @GetMapping("/category/name/{categoryName}")
    public List<Course> getCoursesByCategoryName(@PathVariable String categoryName) {
        return courseService.findByCategoryName(categoryName);
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        if (!courseService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        course.setId(id);
        return ResponseEntity.ok(courseService.save(course));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        if (!courseService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        courseService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}