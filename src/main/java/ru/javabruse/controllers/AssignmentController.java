package ru.javabruse.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.javabruse.entities.Assignment;
import ru.javabruse.services.AssignmentService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/assignments")
@RequiredArgsConstructor
public class AssignmentController {

    private final AssignmentService assignmentService;

    @GetMapping
    public List<Assignment> getAllAssignments() {
        return assignmentService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Assignment> getAssignmentById(@PathVariable Long id) {
        Optional<Assignment> assignment = assignmentService.findById(id);
        return assignment.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Assignment createAssignment(@RequestBody Assignment assignment) {
        return assignmentService.save(assignment);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Assignment> updateAssignment(@PathVariable Long id, @RequestBody Assignment assignment) {
        if (!assignmentService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        assignment.setId(id);
        return ResponseEntity.ok(assignmentService.save(assignment));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAssignment(@PathVariable Long id) {
        if (!assignmentService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        assignmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}