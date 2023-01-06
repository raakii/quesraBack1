package com.quesra.quesra.controller;

import com.quesra.quesra.domain.Answer;
import com.quesra.quesra.domain.Question;
import com.quesra.quesra.dto.AnswerDto;
import com.quesra.quesra.service.AnswerService;
import org.springframework.http.HttpHeaders;
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

   @PostMapping("/create-response")
    public ResponseEntity<Answer> answerQuestion(@RequestBody AnswerDto answerDto) throws Exception {
        Answer answerResponse = answerService.answerQuestion(answerDto);
        if(answerResponse == null ) {
            throw new Exception("Bad request");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(answerResponse);
   }

   @GetMapping("/get-answers/{questionId}")
    public ResponseEntity<List<Answer>> getAnswers(@PathVariable Long questionId) throws Exception {
        if (questionId == null ) {
            throw new Exception("Id must be not null");
        }
        return ResponseEntity.status(HttpStatus.OK).body(answerService.getAnswers(questionId));
   }
}
