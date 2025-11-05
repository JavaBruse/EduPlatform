package ru.javabruse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javabruse.entities.CourseReview;

import java.util.List;

public interface CourseReviewRepository extends JpaRepository<CourseReview, Long> {
    List<CourseReview> findByCourseId(Long courseId);
    List<CourseReview> findByStudentId(Long studentId);
}
