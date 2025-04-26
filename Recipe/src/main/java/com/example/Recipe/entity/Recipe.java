package com.example.Recipe.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(collection = "recipe")
public class Recipe {

    @Id
    private int id;
    private String recipeName;
    private String recipeDescription;
    private String tips;
}
