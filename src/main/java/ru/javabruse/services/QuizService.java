package ru.javabruse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javabruse.entities.Quiz;
import ru.javabruse.repositories.QuizRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final QuizRepository quizRepository;

    public List<Quiz> findAll() {
        return quizRepository.findAll();
    }

    public Optional<Quiz> findById(Long id) {
        return quizRepository.findById(id);
    }

    public Optional<Quiz> findByCourseModuleId(Long courseModuleId) {
        return quizRepository.findByCourseModuleId(courseModuleId);
    }

    public Quiz save(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    public void deleteById(Long id) {
        quizRepository.deleteById(id);
    }
}