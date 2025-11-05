package ru.javabruse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javabruse.entities.Assignment;
import ru.javabruse.repositories.AssignmentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    public List<Assignment> findAll() {
        return assignmentRepository.findAll();
    }

    public Optional<Assignment> findById(Long id) {
        return assignmentRepository.findById(id);
    }

    public List<Assignment> findByLessonId(Long lessonId) {
        return assignmentRepository.findByLessonId(lessonId);
    }

    public Assignment save(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public void deleteById(Long id) {
        assignmentRepository.deleteById(id);
    }
}