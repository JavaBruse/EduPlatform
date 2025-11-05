package ru.javabruse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javabruse.entities.AnswerOption;
import ru.javabruse.repositories.AnswerOptionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnswerOptionService {

    private final AnswerOptionRepository answerOptionRepository;

    public List<AnswerOption> findAll() {
        return answerOptionRepository.findAll();
    }

    public Optional<AnswerOption> findById(Long id) {
        return answerOptionRepository.findById(id);
    }

    public List<AnswerOption> findByQuestionId(Long questionId) {
        return answerOptionRepository.findByQuestionId(questionId);
    }

    public AnswerOption save(AnswerOption answerOption) {
        return answerOptionRepository.save(answerOption);
    }

    public void deleteById(Long id) {
        answerOptionRepository.deleteById(id);
    }
}