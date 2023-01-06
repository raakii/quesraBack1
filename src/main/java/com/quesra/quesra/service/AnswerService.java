package com.quesra.quesra.service;

import com.quesra.quesra.domain.Answer;
import com.quesra.quesra.dto.AnswerDto;

import java.util.List;

public interface AnswerService {
    Answer answerQuestion(AnswerDto answerDto);

    List<Answer> getAnswers(Long questionId);
}
