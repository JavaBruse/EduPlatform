package ru.javabruse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javabruse.entities.CourseModule;
import ru.javabruse.services.CourseModuleService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/modules")
@RequiredArgsConstructor
public class ModuleController {

    private final CourseModuleService moduleService;

    @GetMapping
    public List<CourseModule> getAllModules() {
        return moduleService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CourseModule> getModuleById(@PathVariable Long id) {
        Optional<CourseModule> module = moduleService.findById(id);
        return module.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/course/{courseId}")
    public List<CourseModule> getModulesByCourse(@PathVariable Long courseId) {
        return moduleService.findByCourseId(courseId);
    }

    @PostMapping
    public CourseModule createModule(@RequestBody CourseModule module) {
        return moduleService.save(module);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CourseModule> updateModule(@PathVariable Long id, @RequestBody CourseModule module) {
        if (!moduleService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        module.setId(id);
        return ResponseEntity.ok(moduleService.save(module));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModule(@PathVariable Long id) {
        if (!moduleService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        moduleService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}