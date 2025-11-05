package ru.javabruse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javabruse.entities.CourseReview;
import ru.javabruse.services.CourseReviewService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class CourseReviewController {

    private final CourseReviewService courseReviewService;

    @GetMapping
    public List<CourseReview> getAllReviews() {
        return courseReviewService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseReview> getReviewById(@PathVariable Long id) {
        Optional<CourseReview> review = courseReviewService.findById(id);
        return review.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/course/{courseId}")
    public List<CourseReview> getReviewsByCourse(@PathVariable Long courseId) {
        return courseReviewService.findByCourseId(courseId);
    }

    @GetMapping("/student/{studentId}")
    public List<CourseReview> getReviewsByStudent(@PathVariable Long studentId) {
        return courseReviewService.findByStudentId(studentId);
    }

    @PostMapping
    public CourseReview createReview(@RequestBody CourseReview review) {
        return courseReviewService.save(review);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseReview> updateReview(@PathVariable Long id, @RequestBody CourseReview review) {
        if (!courseReviewService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        review.setId(id);
        return ResponseEntity.ok(courseReviewService.save(review));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReview(@PathVariable Long id) {
        if (!courseReviewService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        courseReviewService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}