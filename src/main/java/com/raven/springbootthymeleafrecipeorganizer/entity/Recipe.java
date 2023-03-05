package com.raven.springbootthymeleafrecipeorganizer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RECIPE_DETAILS")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;

	@Column(name = "recipe_name", columnDefinition = "varchar(100)", nullable = false)
	private String recipeName = "";
	
	@Column(name = "description", columnDefinition = "text")
	private String description = "";

	@Column(name = "dish_type", columnDefinition = "varchar(30)")
	private String dishType = "";

	@Column(name = "difficulty_level", columnDefinition = "varchar(20)")
	private String difficultyLevel = "";

	@Column(name = "preparation_time", columnDefinition = "varchar(20)")
	private String preparationTime = "";

	@Column(name = "cooking_time", columnDefinition = "varchar(20)")
	private String cookingTime = "";

	@Column(name = "ingredients", columnDefinition = "text")
	private String ingredients = "";

	@Column(name = "directions", columnDefinition = "longtext")
	private String directions = "";

	public Recipe() {
	}

	/**
	 * @param recipeName
	 * @param description
	 * @param dishType
	 * @param difficultyLevel
	 * @param preparationTime
	 * @param cookingTime
	 * @param ingredients
	 * @param directions
	 */
	public Recipe(String recipeName, String description, String dishType, String difficultyLevel,
			String preparationTime, String cookingTime, String ingredients, String directions) {
		this.recipeName = recipeName;
		this.description = description;
		this.dishType = dishType;
		this.difficultyLevel = difficultyLevel;
		this.preparationTime = preparationTime;
		this.cookingTime = cookingTime;
		this.ingredients = ingredients;
		this.directions = directions;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return Id;
	}

	/**
	 * @return the recipeName
	 */
	public String getRecipeName() {
		return recipeName;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @return the dishType
	 */
	public String getDishType() {
		return dishType;
	}

	/**
	 * @return the difficultyLevel
	 */
	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	/**
	 * @return the preparationTime
	 */
	public String getPreparationTime() {
		return preparationTime;
	}

	/**
	 * @return the cookingTime
	 */
	public String getCookingTime() {
		return cookingTime;
	}

	/**
	 * @return the ingredients
	 */
	public String getIngredients() {
		return ingredients;
	}

	/**
	 * @return the directions
	 */
	public String getDirections() {
		return directions;
	}

	/**
	 * @param recipeName the recipeName to set
	 */
	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @param dishType the dishType to set
	 */
	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	/**
	 * @param difficultyLevel the difficultyLevel to set
	 */
	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	/**
	 * @param preparationTime the preparationTime to set
	 */
	public void setPreparationTime(String preparationTime) {
		this.preparationTime = preparationTime;
	}

	/**
	 * @param cookingTime the cookingTime to set
	 */
	public void setCookingTime(String cookingTime) {
		this.cookingTime = cookingTime;
	}

	/**
	 * @param ingredients the ingredients to set
	 */
	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	/**
	 * @param directions the directions to set
	 */
	public void setDirections(String directions) {
		this.directions = directions;
	}

	@Override
	public String toString() {
		return "Recipe [Id=" + Id + ", recipeName=" + recipeName + ", description=" + description + ", dishType="
				+ dishType + ", difficultyLevel=" + difficultyLevel + ", preparationTime=" + preparationTime
				+ ", cookingTime=" + cookingTime + ", ingredients=" + ingredients + ", directions=" + directions + "]";
	}
	
}
