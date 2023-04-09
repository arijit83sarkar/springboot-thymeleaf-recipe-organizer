package com.raven.springbootthymeleafrecipeorganizer.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.data.annotation.CreatedDate;

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

	@Column(name = "preparation_time", columnDefinition = "varchar(20)")
	private String preparationTime = "";

	@Column(name = "cooking_time", columnDefinition = "varchar(20)")
	private String cookingTime = "";

	@Column(name = "ingredients", columnDefinition = "text")
	private String ingredients = "";

	@Column(name = "directions", columnDefinition = "longtext")
	private String directions = "";

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "image_id")
	private RecipeImage recipeImage;

	@Transient
	private String imageName = "";

	@Transient
	private String imageURL = "";

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false, updatable = false)
	@CreatedDate
	private Date createdOn = new Date();

	public Recipe() {
	}

	public Recipe(String recipeName, String description, String dishType,
			String preparationTime, String cookingTime, String ingredients, String directions,
			RecipeImage recipeImage) {
		this.recipeName = recipeName;
		this.description = description;
		this.dishType = dishType;
		this.preparationTime = preparationTime;
		this.cookingTime = cookingTime;
		this.ingredients = ingredients;
		this.directions = directions;
		this.recipeImage = recipeImage;
	}

	public int getId() {
		return Id;
	}

	public String getRecipeName() {
		return recipeName;
	}

	public String getDescription() {
		return description;
	}

	public String getDishType() {
		return dishType;
	}

	public String getPreparationTime() {
		return preparationTime;
	}

	public String getCookingTime() {
		return cookingTime;
	}

	public String getIngredients() {
		return ingredients;
	}

	public String getDirections() {
		return directions;
	}

	public RecipeImage getRecipeImage() {
		return recipeImage;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setRecipeName(String recipeName) {
		this.recipeName = recipeName;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setDishType(String dishType) {
		this.dishType = dishType;
	}

	public void setPreparationTime(String preparationTime) {
		this.preparationTime = preparationTime;
	}

	public void setCookingTime(String cookingTime) {
		this.cookingTime = cookingTime;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public void setDirections(String directions) {
		this.directions = directions;
	}

	public void setRecipeImage(RecipeImage recipeImage) {
		this.recipeImage = recipeImage;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getImageURL() {
		return imageURL;
	}

	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	@Override
	public String toString() {
		return "Recipe [Id=" + Id + ", recipeName=" + recipeName + ", description=" + description + ", dishType="
				+ dishType + ", preparationTime=" + preparationTime + ", cookingTime=" + cookingTime + ", ingredients="
				+ ingredients + ", directions=" + directions + ", recipeImage=" + recipeImage + ", imageName="
				+ imageName + ", imageURL=" + imageURL + ", createdOn=" + createdOn + "]";
	}
	
}
