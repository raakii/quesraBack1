package com.quesra.quesra.dto;

import com.quesra.quesra.domain.Question;

public class AnswerDto {
    private String text;
    private String  email;
    private Long questionId;

    public AnswerDto(String text, String email, Long questionId) {
        this.text = text;
        this.email = email;
        this.questionId = questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }
}
