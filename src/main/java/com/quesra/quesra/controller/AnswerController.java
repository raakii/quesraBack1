package com.quesra.quesra.controller;

import com.quesra.quesra.domain.Answer;
import com.quesra.quesra.domain.Question;
import com.quesra.quesra.service.AnswerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

   // @GetMapping("/answers/")
    //public ResponseEntity<List<Answer>> getAnswersFromQuestion(@RequestBody Question question) {
        //return ResponseEntity.status(HttpStatus.OK).body(answerService.findAnswers(question.getId()));
    //}
}
