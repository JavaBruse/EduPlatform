package ru.javabruse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.javabruse.entities.Category;
import ru.javabruse.repositories.CategoryRepository;
import ru.javabruse.services.CategoryService;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryService categoryService;

    @Test
    void findByName_ExistingName_ReturnsCategory() {
        Category category = new Category();
        category.setName("Programming");
        when(categoryRepository.findByName("Programming")).thenReturn(Optional.of(category));

        Optional<Category> result = categoryService.findByName("Programming");

        assertTrue(result.isPresent());
        assertEquals("Programming", result.get().getName());
    }
}