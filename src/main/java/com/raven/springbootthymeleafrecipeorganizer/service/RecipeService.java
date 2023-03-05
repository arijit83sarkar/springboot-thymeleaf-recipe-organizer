package com.raven.springbootthymeleafrecipeorganizer.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raven.springbootthymeleafrecipeorganizer.entity.Recipe;
import com.raven.springbootthymeleafrecipeorganizer.repository.IRecipeRepository;

@Service
public class RecipeService {
	private final IRecipeRepository recipeRepository;

	@Autowired
	public RecipeService(IRecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	public List<Recipe> findAll() {
		return this.recipeRepository.findAll();
	}

	public Recipe findById(int _id) {
		Optional<Recipe> _recipe = this.recipeRepository.findById(_id);

		Recipe recipe;
		if (_recipe.isPresent()) {
			recipe = _recipe.get();
		} else {
			throw new RuntimeException("No recipe with this id :: " + _id);
		}

		return recipe;
	}

	public Recipe saveRecipe(Recipe _recipe) {
		Recipe recipe = this.recipeRepository.save(_recipe);
		return recipe;
	}

	public void deleteById(int _id) {
		this.recipeRepository.deleteById(_id);
	}
}
