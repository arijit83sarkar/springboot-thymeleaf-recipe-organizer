package com.raven.springbootthymeleafrecipeorganizer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raven.springbootthymeleafrecipeorganizer.repository.IRecipeRepository;

@Service
public class RecipeService {
	private final IRecipeRepository recipeRepository;

	@Autowired
	public RecipeService(IRecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

}
