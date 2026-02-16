package com.example.demo.controllers;

import com.example.demo.models.Question;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

    @GetMapping("/author{authorId}")
    public Flux<QuestionResponse> getQuestionByAuthor(){

    }
}
