package com.example.demo.repositories;

import com.example.demo.models.Answer;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AnswerRepository extends ReactiveMongoRepository<Answer, String>{

    Flux<Answer> findByQuestionId(String questionId);

    Mono<Long> countByQuestionId(String questionId);

    Flux<Answer> findByQuestionIdOrderByCreatedDesc(String questionId);

    Flux<Answer> findByQuestionIdOrderByCreatedAtAsc(String questionId);

}
