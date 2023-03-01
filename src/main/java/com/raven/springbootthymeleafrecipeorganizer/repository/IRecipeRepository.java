package com.raven.springbootthymeleafrecipeorganizer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.raven.springbootthymeleafrecipeorganizer.entity.Recipe;

@Repository
public interface IRecipeRepository extends JpaRepository<Recipe, Integer> {

}
