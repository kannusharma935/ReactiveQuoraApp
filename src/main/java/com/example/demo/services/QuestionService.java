package com.example.demo.services;

import com.example.demo.dto.QuestionRequestDto;
import com.example.demo.models.Question;
import com.example.demo.repositories.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class QuestionService implements IQuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Mono<Question> createQuestion(QuestionRequestDto questionRequestDto) {
        Question question=Question.builder().
                title(questionRequestDto.getTitle()).
                content(questionRequestDto.getContent()).
                createdAt(LocalDateTime.now()).
                updateAt(LocalDateTime.now()).build();

        return null;
    }
}
