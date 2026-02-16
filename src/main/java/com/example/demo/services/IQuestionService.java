package com.example.demo.services;

import com.example.demo.dto.QuestionRequestDto;
import com.example.demo.models.Question;
import reactor.core.publisher.Mono;

public interface IQuestionService {
    public Mono<Question> createQuestion(QuestionRequestDto questionRequestDto);
}

