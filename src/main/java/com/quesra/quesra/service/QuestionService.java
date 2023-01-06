package com.quesra.quesra.service;

import com.quesra.quesra.domain.Question;
import com.quesra.quesra.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    Question postQuestion(QuestionDto question);

    List<Question> findAll();

}
