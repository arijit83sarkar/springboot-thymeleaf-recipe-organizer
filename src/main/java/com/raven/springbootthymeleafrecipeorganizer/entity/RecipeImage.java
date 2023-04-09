package com.raven.springbootthymeleafrecipeorganizer.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "RECIPE_IMAGE")
public class RecipeImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int Id;

	@Column(name = "original_filename", columnDefinition = "varchar(40)")
	private String originalFileName = "";

	@Column(name = "path", columnDefinition = "varchar(120)")
	private String path = "";

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_on", nullable = false, updatable = false)
	@CreatedDate
	private Date createdOn = new Date();

	public RecipeImage() {
	}

	public RecipeImage(String originalFileName, String path) {
		this.originalFileName = originalFileName;
		this.path = path;
	}

	public int getId() {
		return Id;
	}

	public String getOriginalFileName() {
		return originalFileName;
	}

	public String getPath() {
		return path;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}

	public void setPath(String path) {
		this.path = path;
	}

	@Override
	public String toString() {
		return "RecipeImage [Id=" + Id + ", originalFileName=" + originalFileName 
				+ ", path=" + path + ", createdOn=" + createdOn + "]";
	}
}
