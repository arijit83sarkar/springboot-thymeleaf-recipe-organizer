package com.raven.springbootthymeleafrecipeorganizer.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.raven.springbootthymeleafrecipeorganizer.entity.Recipe;
import com.raven.springbootthymeleafrecipeorganizer.entity.RecipeImage;
import com.raven.springbootthymeleafrecipeorganizer.repository.IRecipeRepository;

@Service
public class RecipeService {
	private final String IMAGE_UPLOAD_DIR = "./image_uploads/";
	private final IRecipeRepository recipeRepository;

	@Autowired
	public RecipeService(IRecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	public List<Recipe> findAll() {
		return this.recipeRepository.findAll();
		// List<Recipe> recipes = this.recipeRepository.getRecipes();
		// return recipes;
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

	public Recipe saveRecipe(Recipe _recipe, MultipartFile multipartFile) {
		String fileName;
		Recipe recipe = null;
		Path filePath;

		try {
			fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
			String[] splitName = fileName.split("\\.(?=[^\\.]+$)");
			fileName = splitName[0].concat("_").concat(String.valueOf((new Date()).getTime())).concat(".")
					.concat(splitName[1]);
			filePath = Paths.get(IMAGE_UPLOAD_DIR + fileName);
			Files.copy(multipartFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

			RecipeImage recipeImage = new RecipeImage(fileName, filePath.toString());
			_recipe.setRecipeImage(recipeImage);

			recipe = this.recipeRepository.save(_recipe);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return recipe;
	}

	public void deleteById(int _id) {
		this.recipeRepository.deleteById(_id);
	}

	public Resource loadImage(String filename) {
		try {
			Path imageDirPath = Paths.get(this.IMAGE_UPLOAD_DIR);
			Path file = imageDirPath.resolve(filename);
			Resource resource = new UrlResource(file.toUri());

			if (resource.exists() || resource.isReadable()) {
				return resource;
			} else {
				throw new RuntimeException("Could not read the image file.");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}

	public Stream<Path> loadAllImages() {
		try {
			Path imageDirPath = Paths.get(this.IMAGE_UPLOAD_DIR);
			return Files.walk(imageDirPath, 1)
					.filter(path -> !path.equals(imageDirPath)).map(imageDirPath::relativize);
		} catch (IOException e) {
			throw new RuntimeException("Could not load the image files.");
		}
	}
}
