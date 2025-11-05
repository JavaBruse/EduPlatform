package ru.javabruse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javabruse.entities.Submission;

import java.util.Optional;
import java.util.List;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    List<Submission> findByAssignmentId(Long assignmentId);
    List<Submission> findByStudentId(Long studentId);
    Optional<Submission> findByAssignmentIdAndStudentId(Long assignmentId, Long studentId);
}
