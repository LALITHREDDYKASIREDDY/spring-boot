package com.example.LearningPortal.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.LearningPortal.model.Category;
import com.example.LearningPortal.service.CategoryService;

/**
 * Controller class responsible for handling HTTP requests related to categories.
 * Exposes endpoints for CRUD operations on categories.
 */
@RestController
public class CategoryController {

	@Autowired
	CategoryService categoryService;

	@GetMapping("/categories")
	public ArrayList<Category> getCategories() {
		return categoryService.getCategories();
	}

	@GetMapping("/categories/{categoryId}")
	public Category getCategoryById(@PathVariable("categoryId") int id) {
		return categoryService.getCategoryById(id);
	}

	@PostMapping("/categories")
	public Category addCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}

	@PutMapping("/categories/{categoryId}")
	public Category updateCategoryById(@PathVariable("categoryId") int id, @RequestBody Category category) {
		return categoryService.updateCategory(category, id);
	}

	@DeleteMapping("/categories/{categoryId}")
	public void deleteCategoryById(@PathVariable("categoryId") int id) {
		categoryService.deleteCategory(id);
	}
}
