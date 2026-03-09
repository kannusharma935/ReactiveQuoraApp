package com.example.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection="likes")
public class Like {

    @Id
    private String id;

    private String targetId;

    private String targetType;//Question,Answer

    private Boolean isLike;

    @CreatedDate
    private LocalDateTime createdAt;
}
