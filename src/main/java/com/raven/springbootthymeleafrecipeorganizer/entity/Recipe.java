package com.raven.springbootthymeleafrecipeorganizer.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENGINE")
public class Recipe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;

	@Column(name = "recipe_name", columnDefinition = "varchar(100)", nullable = false)
	private String recipeName = "";

	@Column(name = "dish_type", columnDefinition = "varchar(30)")
	private String dishType = "";

	@Column(name = "difficulty_level", columnDefinition = "varchar(20)")
	private String difficultyLevel = "";

	@Column(name = "preparation_time", columnDefinition = "varchar(20)")
	private String preparationTime = "";

	@Column(name = "cooking_time", columnDefinition = "varchar(20)")
	private String cookingTime = "";

	@Column(name = "ingredients", columnDefinition = "varchar(250)")
	private String ingredients = "";

	@Column(name = "directions", columnDefinition = "varchar(1024)")
	private String directions = "";

	public Recipe() {
	}

	public Recipe(String recipeName, String dishType, String difficultyLevel, String preparationTime,
			String cookingTime, String ingredients, String directions) {
		this.recipeName = recipeName;
		this.dishType = dishType;
		this.difficultyLevel = difficultyLevel;
		this.preparationTime = preparationTime;
		this.cookingTime = cookingTime;
		this.ingredients = ingredients;
		this.directions = directions;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public String getDishType() {
		return dishType;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	public String getDifficultyLevel() {
		return difficultyLevel;
	}

	public void setDifficultyLevel(String difficultyLevel) {
		this.difficultyLevel = difficultyLevel;
	}

	public String getPreparationTime() {
		return preparationTime;
	}

	public void setPreparationTime(String preparationTime) {
		this.preparationTime = preparationTime;
	}

	public String getCookingTime() {
		return cookingTime;
	}

	public void setCookingTime(String cookingTime) {
		this.cookingTime = cookingTime;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public String getDirections() {
		return directions;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public int getId() {
		return Id;
	}

	@Override
	public String toString() {
		return "Recipe [Id=" + Id + ", recipeName=" + recipeName + ", dishType=" + dishType + ", difficultyLevel="
				+ difficultyLevel + ", preparationTime=" + preparationTime + ", cookingTime=" + cookingTime
				+ ", ingredients=" + ingredients + ", directions=" + directions + "]";
	}
}
