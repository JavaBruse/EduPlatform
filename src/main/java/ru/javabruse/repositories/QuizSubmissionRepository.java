package ru.javabruse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javabruse.entities.QuizSubmission;

import java.util.List;
import java.util.Optional;

public interface QuizSubmissionRepository extends JpaRepository<QuizSubmission, Long> {
    List<QuizSubmission> findByStudentId(Long studentId);
    List<QuizSubmission> findByQuizId(Long quizId);
    Optional<QuizSubmission> findByQuizIdAndStudentId(Long quizId, Long studentId);
}
