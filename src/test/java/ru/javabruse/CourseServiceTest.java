
package ru.javabruse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.javabruse.entities.Course;
import ru.javabruse.repositories.CourseRepository;
import ru.javabruse.services.CourseService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CourseServiceTest {

    @Mock
    private CourseRepository courseRepository;

    @InjectMocks
    private CourseService courseService;

    @Test
    void findAll_ReturnsAllCourses() {
        Course course1 = new Course();
        Course course2 = new Course();
        when(courseRepository.findAll()).thenReturn(Arrays.asList(course1, course2));

        List<Course> result = courseService.findAll();

        assertEquals(2, result.size());
    }

    @Test
    void findByTeacherId_ExistingTeacher_ReturnsCourses() {
        Course course = new Course();
        when(courseRepository.findByTeacherId(1L)).thenReturn(Arrays.asList(course));

        List<Course> result = courseService.findByTeacherId(1L);

        assertFalse(result.isEmpty());
    }
}