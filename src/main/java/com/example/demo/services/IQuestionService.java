package com.example.demo.services;

import com.example.demo.dto.QuestionRequestDto;
import com.example.demo.dto.QuestionResponseDto;
import com.example.demo.models.Question;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IQuestionService {

    public Mono<QuestionResponseDto> createQuestion(QuestionRequestDto questionRequestDTO);

    public Flux<QuestionResponseDto> searchQuestions(String searchTerm, int offset, int page);

    public Flux<QuestionResponseDto> getAllQuestions(String cursor, int size);

    public Mono<QuestionResponseDto> getQuestionById(String id);

//    public List<QuestionElasticDocument> searchQuestionsByElasticsearch(String query);
}

