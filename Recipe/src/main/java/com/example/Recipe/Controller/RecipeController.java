package com.example.Recipe.Controller;

import com.example.Recipe.Service.RecipeService;
import com.example.Recipe.dto.RecipeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/recipe")
@CrossOrigin
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @GetMapping("/getAll")
    public List<RecipeDto> getRecipe(){
        return recipeService.getAllRecipes();
    }

    @PostMapping("/save")
    public RecipeDto saveRecipe(@RequestBody RecipeDto recipeDto){
        return recipeService.saveRecipe(recipeDto);
    }

    @PutMapping("/update")
    public RecipeDto updateRecipe(@RequestBody RecipeDto recipeDto){
        return recipeService.updateRecipe(recipeDto);
    }
    @DeleteMapping("/delete")
    public boolean deleteRecipe(@RequestBody RecipeDto recipeDto){
        return recipeService.deleteRecipe(recipeDto);
    }

    @GetMapping("/get/{id}")
    public RecipeDto getRecipeById(@PathVariable Integer id){
        return recipeService.getRecipeById(id);
    }
}
