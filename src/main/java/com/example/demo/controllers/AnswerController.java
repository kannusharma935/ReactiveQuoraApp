package com.example.demo.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping
    public Mono<ResponseEntity<AnswerResponseDTO>> createAnswer(){

    }

    @GetMapping("/{id}")
    public getAnswerById(@PathVariable String id){

    }
    @PutMapping("/{id}")
    public updateAnswer(@PathVariable String id,
                         @Valid @ResponseBody AnswerRequestDTO answerRequestDTO){

    }

    @DeleteMapping("/{id}")
    public deleteAnswer(@PathVariable String id){

    }
    @GetMapping
    public Flux<AnswerResponseDTO> getAllAnswers() {
        return answerService.getAllAnswers();
    }

}
