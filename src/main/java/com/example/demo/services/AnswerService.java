package com.example.demo.services;

import com.example.demo.dto.AnswerRequestDTO;
import com.example.demo.dto.AnswerResponseDTO;
import com.example.demo.models.Answer;
import com.example.demo.repositories.AnswerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;


    public Mono<AnswerResponseDTO> createAnswer(AnswerRequestDTO answerRequestDTO){
        Answer answer=Answer.builder().content(answerRequestDTO.getContent())
                .questionId(answerRequestDTO.getQuestionId())
                .build();
        return answerRepository.save(answer)
                .map(this::mapToResponseDTO);

    }


    private AnswerResponseDTO mapToResponseDTO(Answer answer) {
        return AnswerResponseDTO.builder()
                .id(answer.getId())
                .content(answer.getContent())
                .questionId(answer.getQuestionId())
                .updatedAt(answer.getUpdatedAt())
                .build();
    }
}
