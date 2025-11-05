package ru.javabruse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javabruse.entities.Enrollment;
import ru.javabruse.services.EnrollmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/enrollments")
@RequiredArgsConstructor
public class EnrollmentController {

    private final EnrollmentService enrollmentService;

    @GetMapping
    public List<Enrollment> getAllEnrollments() {
        return enrollmentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long id) {
        Optional<Enrollment> enrollment = enrollmentService.findById(id);
        return enrollment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/student/{studentId}")
    public List<Enrollment> getEnrollmentsByStudent(@PathVariable Long studentId) {
        return enrollmentService.findByStudentId(studentId);
    }

    @GetMapping("/course/{courseId}")
    public List<Enrollment> getEnrollmentsByCourse(@PathVariable Long courseId) {
        return enrollmentService.findByCourseId(courseId);
    }

    @GetMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Enrollment> getEnrollmentByStudentAndCourse(
            @PathVariable Long studentId, @PathVariable Long courseId) {
        Optional<Enrollment> enrollment = enrollmentService.findByStudentAndCourse(studentId, courseId);
        return enrollment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Enrollment createEnrollment(@RequestBody Enrollment enrollment) {
        return enrollmentService.save(enrollment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Enrollment> updateEnrollment(@PathVariable Long id, @RequestBody Enrollment enrollment) {
        if (!enrollmentService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        enrollment.setId(id);
        return ResponseEntity.ok(enrollmentService.save(enrollment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnrollment(@PathVariable Long id) {
        if (!enrollmentService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        enrollmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}