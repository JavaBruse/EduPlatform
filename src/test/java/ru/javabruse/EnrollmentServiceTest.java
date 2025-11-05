package ru.javabruse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.javabruse.entities.Enrollment;
import ru.javabruse.repositories.EnrollmentRepository;
import ru.javabruse.services.EnrollmentService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class EnrollmentServiceTest {

    @Mock
    private EnrollmentRepository enrollmentRepository;

    @InjectMocks
    private EnrollmentService enrollmentService;

    @Test
    void findByStudentAndCourse_ExistingEnrollment_ReturnsEnrollment() {
        Enrollment enrollment = new Enrollment();
        when(enrollmentRepository.findByStudentIdAndCourseId(1L, 1L)).thenReturn(Optional.of(enrollment));

        Optional<Enrollment> result = enrollmentService.findByStudentAndCourse(1L, 1L);

        assertTrue(result.isPresent());
    }

    @Test
    void deleteById_ExistingId_DeletesSuccessfully() {
        doNothing().when(enrollmentRepository).deleteById(1L);

        assertDoesNotThrow(() -> enrollmentService.deleteById(1L));
        verify(enrollmentRepository, times(1)).deleteById(1L);
    }
}