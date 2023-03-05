package com.raven.springbootthymeleafrecipeorganizer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.raven.springbootthymeleafrecipeorganizer.entity.Recipe;
import com.raven.springbootthymeleafrecipeorganizer.service.RecipeService;

@Controller
@RequestMapping("/recipe")
public class RecipeController {
	private final RecipeService recipeService;

	@Autowired
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}

	@GetMapping("/list")
	public ModelAndView getRecipeList() {
		List<Recipe> recipes = this.recipeService.findAll();
//		System.out.println(recipes.toString());

		ModelAndView modelAndView = new ModelAndView("recipe/recipelist");
		modelAndView.addObject("recipes", recipes);

		return modelAndView;
	}

}
