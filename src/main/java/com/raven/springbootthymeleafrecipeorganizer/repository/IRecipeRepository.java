package com.raven.springbootthymeleafrecipeorganizer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.raven.springbootthymeleafrecipeorganizer.entity.Recipe;

@Repository
public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {

	// @Query(nativeQuery = true, value = "select rd.id, rd.cooking_time, rd.directions, "
	// 		+ "rd.dish_type, rd.ingredients, rd.preparation_time, "
	// 		+ "case when length(rd.recipe_name)>30 then CONCAT(SUBSTRING(rd.recipe_name, 1, 30), '...') else rd.recipe_name end as recipe_name, "
	// 		+ "case when length(rd.description)>90 then CONCAT(SUBSTRING(rd.description, 1, 90), '...') else rd.description end as description, "
	// 		+ "rd.created_on, rd.image_id from recipe_details as rd")
	@Query(nativeQuery = true, value = "select rd.id, rd.cooking_time, rd.directions, "
			+ "rd.dish_type, rd.ingredients, rd.preparation_time, rd.recipe_name as recipe_name, "
			+ "rd.description as description, rd.created_on, rd.image_id from recipe_details as rd")
	public List<Recipe> getRecipes();
}
