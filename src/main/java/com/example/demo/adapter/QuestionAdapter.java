package com.example.demo.adapter;


import com.example.demo.dto.QuestionResponseDto;
import com.example.demo.models.Question;

public class QuestionAdapter {

    public static QuestionResponseDto toQuestionResponseDTO(Question question) {
        return QuestionResponseDto.builder()
                .id(question.getId())
                .title(question.getTitle())
                .content(question.getContent())
                .createdAt(question.getCreatedAt())
                .build();
    }
}
