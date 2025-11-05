package ru.javabruse.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.javabruse.entities.CourseModule;
import ru.javabruse.repositories.ModuleRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseModuleService {

    private final ModuleRepository moduleRepository;

    public List<CourseModule> findAll() {
        return moduleRepository.findAll();
    }

    public Optional<CourseModule> findById(Long id) {
        return moduleRepository.findById(id);
    }

    public List<CourseModule> findByCourseId(Long courseId) {
        return moduleRepository.findByCourseId(courseId);
    }

    public CourseModule save(CourseModule courseModule) {
        return moduleRepository.save(courseModule);
    }

    public void deleteById(Long id) {
        moduleRepository.deleteById(id);
    }
}