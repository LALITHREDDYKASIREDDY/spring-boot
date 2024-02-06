package com.example.LearningPortal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.LearningPortal.model.Category;
import com.example.LearningPortal.model.Course;
import com.example.LearningPortal.repository.CategoryJpaRepository;
import com.example.LearningPortal.repository.CategoryRepository;
import com.example.LearningPortal.repository.CourseJpaRepository;

@Service
public class CategoryService implements CategoryRepository {
	@Autowired
	CategoryJpaRepository categoryJpaRepository;
	@Autowired
	CourseJpaRepository courseJpaRepository;

	@Override
	public ArrayList<Category> getCategories() {

		return (ArrayList<Category>) categoryJpaRepository.findAll();
	}

	@Override
	public Category getCategoryById(int id) {
		try {
			return categoryJpaRepository.findById(id).get();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Category addCategory(Category category) {
		try {
			List<Integer> coursesIds = new ArrayList<>();
			for (Course course : category.getCourses()) {
				coursesIds.add(course.getCourseId());
			}
			category.setCourses(courseJpaRepository.findAllById(coursesIds));
			categoryJpaRepository.save(category);
			return category;

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public Category updateCategory(Category category, int id) {
		try {
			Category orginal = categoryJpaRepository.findById(id).get();

			if (category.getCategoryName() != null) {
				orginal.setCategoryName(category.getCategoryName());
			}
			if (category.getCourses() != null) {
				List<Integer> coursesIds = new ArrayList<>();
				for (Course course : category.getCourses()) {
					coursesIds.add(course.getCourseId());
				}
				orginal.setCourses(courseJpaRepository.findAllById(coursesIds));
			}
			categoryJpaRepository.save(orginal);
			return orginal;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public void deleteCategory(int id) {
		try {
			Category category = categoryJpaRepository.findById(id).get();
			categoryJpaRepository.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

}
