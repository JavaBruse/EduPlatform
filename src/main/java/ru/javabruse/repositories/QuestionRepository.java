package ru.javabruse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.javabruse.entities.Question;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findByQuizId(Long quizId);
}
