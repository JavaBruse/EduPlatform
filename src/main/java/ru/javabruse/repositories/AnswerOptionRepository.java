package ru.javabruse.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.javabruse.entities.AnswerOption;

import java.util.List;

public interface AnswerOptionRepository extends JpaRepository<AnswerOption, Long> {
    List<AnswerOption> findByQuestionId(Long questionId);
}
