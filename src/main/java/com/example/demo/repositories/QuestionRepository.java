package com.example.demo.repositories;

import com.example.demo.models.Question;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question,String> {
    // Whenever you have to  store set of records u use Flux(it process data as stream).
    // Flux is not list it is a data type that act as a producer can that can produce more thant one data.
    //Mono produce single data
    @Query("{ '$or': [ { 'title': { $regex: ?0, $options: 'i'} }, { 'content' : { $regex: ?0, $options: 'i' } } ] }")
    Flux<Question> findByTitleOrContentContainingIgnoreCase(String searchTerm, Pageable pageable);
    Flux<Question> findByAuthorId(String authorId);

    Mono<Long> countByAuthorId(String authorId);
}
