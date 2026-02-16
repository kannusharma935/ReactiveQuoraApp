package com.example.demo.controllers;

import com.example.demo.dto.QuestionRequestDto;
import com.example.demo.dto.QuestionResponseDto;
import com.example.demo.models.Question;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @PostMapping()
    public Mono<QuestionResponseDto> createQuestion(@RequestBody QuestionRequestDto questionRequestDto){
        return null;
    }

    @GetMapping("/{id}")
    public Mono<QuestionResponseDto> getQuestionById(@PathVariable String id){
        return null;
    }

    @GetMapping()
    public Flux<QuestionResponseDto> getAllQuestions(@RequestParam(required = false) String cursor,@RequestParam(defaultValue="10") int size){
        return null;
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteQuestionById(@PathVariable String id){
        throw new UnsupportedOperationException("not impl");
    }

    @GetMapping("/search")
    public Flux<QuestionResponseDto> searchQuestions(@RequestParam String query,@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size){
        throw  new UnsupportedOperationException("not impl");
    }


}
