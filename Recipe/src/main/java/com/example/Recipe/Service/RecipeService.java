package com.example.Recipe.Service;

import com.example.Recipe.Repo.RecipeRepo;
import com.example.Recipe.dto.RecipeDto;
import com.example.Recipe.entity.Recipe;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RecipeService {

    @Autowired
    private RecipeRepo recipeRepo;
    @Autowired
    private ModelMapper modelMapper;
    public RecipeDto saveRecipe(RecipeDto recipeDto){
        recipeRepo.save(modelMapper.map(recipeDto, Recipe.class));
        return recipeDto;
    }

    public List<RecipeDto> getAllRecipes(){
        List<Recipe>recipeList=recipeRepo.findAll();
        return modelMapper.map(recipeList,new TypeToken<List<RecipeDto>>(){}.getType());
    }

    public RecipeDto updateRecipe(RecipeDto recipeDto){
        recipeRepo.save(modelMapper.map(recipeDto,Recipe.class));
        return recipeDto;
    }

    public boolean deleteRecipe(RecipeDto recipeDto){
        recipeRepo.delete(modelMapper.map(recipeDto,Recipe.class));
        return true;
    }

    public RecipeDto getRecipeById(Integer id){
        Recipe recipe = recipeRepo.getRecipeById(Integer.valueOf(id));
        return modelMapper.map(recipe,RecipeDto.class);
    }
}
