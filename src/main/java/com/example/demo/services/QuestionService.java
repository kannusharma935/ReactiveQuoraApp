package com.example.demo.services;

import com.example.demo.adapter.QuestionAdapter;
import com.example.demo.dto.QuestionRequestDto;
import com.example.demo.dto.QuestionResponseDto;
import com.example.demo.models.Question;
import com.example.demo.repositories.QuestionRepository;
import com.example.demo.utils.CursorUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class QuestionService implements IQuestionService {

    private final QuestionRepository questionRepository;

    @Override
    public Mono<QuestionResponseDto> createQuestion(QuestionRequestDto questionRequestDto) {
        Question question=Question.builder().
                title(questionRequestDto.getTitle()).
                content(questionRequestDto.getContent()).
                createdAt(LocalDateTime.now()).
                updateAt(LocalDateTime.now()).build();

        return questionRepository.save(question)
                .map(savedQuestion->{return QuestionAdapter.toQuestionResponseDTO(savedQuestion);})
                .doOnSuccess(response -> System.out.println("Question created successfully: " + response))
                .doOnError(error -> System.out.println("Error creating question: " + error));
    }

    @Override
    public Flux<QuestionResponseDto> searchQuestions(String searchTerm, int offset, int page) {
//        Pageable pageable=PageRequest(offset,page);
        return questionRepository.findByTitleOrContentContainingIgnoreCase(searchTerm, PageRequest.of(offset,page))
                .map(QuestionAdapter::toQuestionResponseDTO)
                .doOnError(error-> System.out.println(error))
                .doOnComplete(()-> System.out.println("questions fetched successfully"));
    }

    @Override
    public Flux<QuestionResponseDto> getAllQuestions(String cursor, int size) {
        Pageable pageable=PageRequest.of(0,size);
        if(!CursorUtils.isValidCursor(cursor)){
            return questionRepository.findTop10ByOrderByCreatedAtAsc().
                    take(size)
                    .map(QuestionAdapter::toQuestionResponseDTO)
                    .doOnError(e-> System.out.println(e))
                    .doOnComplete(() -> System.out.println("Questions fetched successfully"));
        }
        else {
            LocalDateTime cursorTimeStamp=CursorUtils.parseCursor(cursor);
            return questionRepository.findByCreatedAtGreaterThanOrderByCreatedAtAsc(cursorTimeStamp,pageable)
                    .map(QuestionAdapter::toQuestionResponseDTO)
                    .doOnError(error -> System.out.println("Error fetching questions: " + error))
                    .doOnComplete(() -> System.out.println("Questions fetched successfully"));
        }
    }

    @Override
    public Mono<QuestionResponseDto> getQuestionById(String id) {
        return questionRepository.findById(id)
                .map(QuestionAdapter::toQuestionResponseDTO)
                .doOnError(error -> System.out.println("Error fetching question: " + error))
                .doOnSuccess(response -> {
                    System.out.println("Question fetched successfully: " + response);
//                    ViewCountEvent viewCountEvent = new ViewCountEvent(id, "question", LocalDateTime.now());
//                    kafkaEventProducer.publishViewCountEvent(viewCountEvent);
                });
    }
}
