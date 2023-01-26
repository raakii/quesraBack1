package com.quesra.quesra.service;

import com.quesra.quesra.domain.Question;
import com.quesra.quesra.dto.LikeDto;
import com.quesra.quesra.dto.QuestionDto;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface QuestionService {
    Question postQuestion(QuestionDto question);

    List<Question> findAll();

    Integer getNumberOfLikes(Long postId);

    boolean isLiked(@RequestParam Long postId, @RequestParam Long userId);
}
