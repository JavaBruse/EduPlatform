package ru.javabruse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javabruse.entities.Lesson;
import ru.javabruse.services.LessonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable Long id) {
        Optional<Lesson> lesson = lessonService.findById(id);
        return lesson.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/module/{moduleId}")
    public List<Lesson> getLessonsByModule(@PathVariable Long moduleId) {
        return lessonService.findByCourseModuleId(moduleId);
    }

    @PostMapping
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonService.save(lesson);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable Long id, @RequestBody Lesson lesson) {
        if (!lessonService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        lesson.setId(id);
        return ResponseEntity.ok(lessonService.save(lesson));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLesson(@PathVariable Long id) {
        if (!lessonService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        lessonService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}