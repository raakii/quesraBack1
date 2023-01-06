package com.quesra.quesra.service.Impl;

import com.quesra.quesra.domain.Answer;
import com.quesra.quesra.dto.AnswerDto;
import com.quesra.quesra.repository.AnswerRepository;
import com.quesra.quesra.repository.QuestionRepository;
import com.quesra.quesra.service.AnswerService;
import com.quesra.quesra.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnswerServiceImpl implements AnswerService {

    private  final UserService userService;
    private final AnswerRepository answerRepository;
    private final QuestionRepository questionRepository;

    public AnswerServiceImpl(UserService userService,
                             AnswerRepository answerRepository,
                             QuestionRepository questionRepository) {
        this.userService = userService;
        this.answerRepository = answerRepository;
        this.questionRepository = questionRepository;
    }

    @Override
    public Answer answerQuestion(AnswerDto answerDto) {
        Answer answer = new Answer();
        answer.setText(answerDto.getText());
        answer.setUser(userService.findByEmail(answerDto.getEmail()));
        answer.setQuestion(questionRepository.findById(answerDto.getQuestionId()).get());

        return answerRepository.save(answer);
    }

    @Override
    public List<Answer> getAnswers(Long questionId) {
        return answerRepository.findByQuestion(questionRepository.findById(questionId).get());
    }
}
