package com.quesra.quesra.service.Impl;

import com.quesra.quesra.domain.Question;
import com.quesra.quesra.domain.User;
import com.quesra.quesra.dto.LikeDto;
import com.quesra.quesra.dto.QuestionDto;
import com.quesra.quesra.repository.QuestionRepository;
import com.quesra.quesra.repository.UserRepository;
import com.quesra.quesra.service.QuestionService;
import com.quesra.quesra.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final QuestionRepository questionRepository;
    private final UserRepository userRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository,
                               UserRepository userRepository) {
        this.questionRepository = questionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Question postQuestion(QuestionDto questionDto) {
        Question question = new Question();
        question.setText(questionDto.getText());
        question.setUser(userRepository.findByEmail(questionDto.getEmail()));

        return questionRepository.save(question);
    }

    @Override
    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    @Override
    public Integer getNumberOfLikes(Long postId) {

        return questionRepository.findById(postId).get().getLikes().size();
    }

    @Override
    public boolean isLiked(@RequestParam Long postId, @RequestParam Long userId) {
        Integer size = questionRepository.findById(postId).get().getLikes()
                .stream().filter(user -> user.getId().equals(userId))
                .collect(Collectors.toList()).size();
        if (size == 1 )
            return true;
        else
            return false;
    }

}
