package ru.javabruse;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.javabruse.entities.AnswerOption;
import ru.javabruse.repositories.AnswerOptionRepository;
import ru.javabruse.services.AnswerOptionService;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AnswerOptionServiceTest {

    @Mock
    private AnswerOptionRepository answerOptionRepository;

    @InjectMocks
    private AnswerOptionService answerOptionService;

    @Test
    void findByQuestionId_ExistingQuestion_ReturnsOptions() {
        AnswerOption option1 = new AnswerOption();
        AnswerOption option2 = new AnswerOption();
        when(answerOptionRepository.findByQuestionId(1L)).thenReturn(Arrays.asList(option1, option2));

        List<AnswerOption> result = answerOptionService.findByQuestionId(1L);

        assertEquals(2, result.size());
    }
}