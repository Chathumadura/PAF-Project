package com.example.Recipe.Repo;


import com.example.Recipe.entity.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends MongoRepository<Recipe,Integer> {
    @Query("{ 'id': ?0 }")
    Recipe getRecipeById(Integer id);

}
