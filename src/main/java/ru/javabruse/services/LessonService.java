package ru.javabruse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javabruse.entities.Lesson;
import ru.javabruse.repositories.LessonRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LessonService {

    private final LessonRepository lessonRepository;

    public List<Lesson> findAll() {
        return lessonRepository.findAll();
    }

    public Optional<Lesson> findById(Long id) {
        return lessonRepository.findById(id);
    }

    public List<Lesson> findByCourseModuleId(Long courseModuleId) {
        return lessonRepository.findByCourseModuleId(courseModuleId);
    }

    public Lesson save(Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    public void deleteById(Long id) {
        lessonRepository.deleteById(id);
    }
}