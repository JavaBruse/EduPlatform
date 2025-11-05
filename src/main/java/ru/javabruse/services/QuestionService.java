package ru.javabruse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javabruse.entities.Question;
import ru.javabruse.repositories.QuestionRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    public List<Question> findByQuizId(Long quizId) {
        return questionRepository.findByQuizId(quizId);
    }

    public Question save(Question question) {
        return questionRepository.save(question);
    }

    public void deleteById(Long id) {
        questionRepository.deleteById(id);
    }
}