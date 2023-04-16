package com.raven.springbootthymeleafrecipeorganizer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

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
		List<Recipe> recipes = new ArrayList<>();

		List<Recipe> recipeList = this.recipeService.findAll();
		// System.out.println(recipes.toString());
		// this.getImageList();

		recipeList.forEach(t -> {
			// RecipeImage recipeImage = t.getRecipeImage();
			// String __fileName = t.getRecipeImage().getOriginalFileName().toString();
			// String __Url = MvcUriComponentsBuilder
			// .fromMethodName(RecipeController.class, "getImage",
			// t.getRecipeImage().getOriginalFileName().toString())
			// .build().toString();
			// t.setImageName(t.getRecipeImage().getOriginalFileName().toString());
			// System.out.println(__fileName + " : " + __Url);

			t.setImageName(t.getRecipeImage().getOriginalFileName());
			t.setImageURL(MvcUriComponentsBuilder
					.fromMethodName(RecipeController.class, "getImage",
							t.getRecipeImage().getOriginalFileName())
					.build().toString());

			recipes.add(t);
		});
		// System.out.println("\n\nRecipe List :: " + recipes + "\n\n");

		ModelAndView modelAndView = new ModelAndView("recipe/recipelist");
		modelAndView.addObject("recipes", recipes);

		return modelAndView;
	}

	@GetMapping("/new")
	public ModelAndView newRecipe() {
		ModelAndView modelAndView = new ModelAndView("recipe/newrecipe");
		modelAndView.addObject("recipe", new Recipe());

		return modelAndView;
	}

	@PostMapping("/save")
	public String saveRecipe(@ModelAttribute("recipe") Recipe recipe,
							 @RequestParam("inputFile") MultipartFile multipartFile) {
		Recipe savedRecipe = this.recipeService.saveRecipe(recipe, multipartFile);

		return "redirect:/recipe/list";
	}

	@GetMapping("/view/{id}")
	public ModelAndView getRecipe(@PathVariable(name = "id") int id) {
		Recipe recipe = this.recipeService.findById(id);
		recipe.setImageName(recipe.getRecipeImage().getOriginalFileName());
		recipe.setImageURL(MvcUriComponentsBuilder
				.fromMethodName(RecipeController.class, "getImage",
						recipe.getRecipeImage().getOriginalFileName())
				.build().toString());

		ModelAndView modelAndView = new ModelAndView("recipe/viewrecipe");
		modelAndView.addObject("recipe", recipe);

		return modelAndView;
	}

	@GetMapping("/images/{fileName}")
	public ResponseEntity<Resource> getImage(@PathVariable(name = "fileName") String fileName) {
		Resource file = this.recipeService.loadImage(fileName);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);
	}

	// public void getImageList() {
	// List<String> imageList = this.recipeService.loadAllImages().map(t -> {
	// String __fileName = t.getFileName().toString();
	// String __Url = MvcUriComponentsBuilder
	// .fromMethodName(RecipeController.class, "getImage",
	// t.getFileName().toString()).build().toString();
	// return __fileName + "," + __Url;
	// }).collect(Collectors.toList());

	// System.out.println("\nImage list :: " + imageList.toString());
	// }

}
