package ru.javabruse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javabruse.entities.Enrollment;
import ru.javabruse.repositories.EnrollmentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public List<Enrollment> findAll() {
        return enrollmentRepository.findAll();
    }

    public Optional<Enrollment> findById(Long id) {
        return enrollmentRepository.findById(id);
    }

    public List<Enrollment> findByStudentId(Long studentId) {
        return enrollmentRepository.findByStudentId(studentId);
    }

    public List<Enrollment> findByCourseId(Long courseId) {
        return enrollmentRepository.findByCourseId(courseId);
    }

    public Optional<Enrollment> findByStudentAndCourse(Long studentId, Long courseId) {
        return enrollmentRepository.findByStudentIdAndCourseId(studentId, courseId);
    }

    public Enrollment save(Enrollment enrollment) {
        return enrollmentRepository.save(enrollment);
    }

    public void deleteById(Long id) {
        enrollmentRepository.deleteById(id);
    }
}