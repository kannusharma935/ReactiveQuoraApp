package com.example.demo.models;

import com.mongodb.lang.NonNull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "questions")
public class Question {
    @Id
    private String id;

    @NotBlank(message = "required")
    @Size(min = 10,max = 100,message = "Title must be between 10 and 100 characters")
    private String title;
    @NotBlank(message = "required")
    @Size(min = 10,max = 1000,message = "Content must be between 10 and 100 characters")
    private String content;

    @CreatedDate
    private LocalDateTime createdAt;

    @LastModifiedDate
    private  LocalDateTime updateAt;

}
//do we have database migration in mongo db

//we have db migration in rdbms is that everyone should have same schema in there machine

//but there is no schema in mongodb so there is of no use.