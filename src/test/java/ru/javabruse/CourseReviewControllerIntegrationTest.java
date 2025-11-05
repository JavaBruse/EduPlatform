package ru.javabruse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class CourseReviewControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getReviewsByCourse_ExistingCourse_ReturnsReviews() throws Exception {
        mockMvc.perform(get("/api/reviews/course/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());
    }
}