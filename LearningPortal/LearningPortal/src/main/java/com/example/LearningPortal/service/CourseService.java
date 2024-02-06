package com.example.LearningPortal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.LearningPortal.model.Category;
import com.example.LearningPortal.model.Course;
import com.example.LearningPortal.model.Section;
import com.example.LearningPortal.model.User;
import com.example.LearningPortal.repository.CategoryJpaRepository;
import com.example.LearningPortal.repository.CourseJpaRepository;
import com.example.LearningPortal.repository.CourseRepository;
import com.example.LearningPortal.repository.SectionJpaRepository;
import com.example.LearningPortal.repository.UserJpaRepository;

@Service
public class CourseService implements CourseRepository {
	@Autowired
	CourseJpaRepository courseJpaRepository;
	@Autowired
	CategoryJpaRepository categoryJpaRepository;
	@Autowired
	UserJpaRepository userJpaRepository;
	@Autowired
	SectionJpaRepository sectionJpaRepository;

	@Autowired

	@Override
	public ArrayList<Course> getCourses() {
		return (ArrayList<Course>) courseJpaRepository.findAll();
	}

	@Override
	public Course getCourseById(int id) {
		try {
			return courseJpaRepository.findById(id).get();
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Course addCourse(Course course) {
		try {
			int catId = course.getCategory().getCategoryId();
			Category category = categoryJpaRepository.findById(catId).get();
			course.setCategory(category);

			int authorId = course.getAuthor().getUserId();
			User author = userJpaRepository.findById(authorId).get();
			course.setAuthor(author);
			List<Section> sections = course.getSections();
			List<Integer> sectionIds = new ArrayList<>();

			for (Section section : sections) {
				sectionIds.add(section.getSectionId());
			}
			course.setSections(sectionJpaRepository.findAllById(sectionIds));
			List<User> enrolledUsers = course.getEnrolledUsers();
			List<Integer> enrolledUserIds = new ArrayList<>();

			for (User enrolledUser : enrolledUsers) {
				enrolledUserIds.add(enrolledUser.getUserId());
			}
			course.setEnrolledUsers(userJpaRepository.findAllById(enrolledUserIds));
			category.getCourses().add(course);
			categoryJpaRepository.save(category);
			courseJpaRepository.save(course);
			System.out.println(course.getCreatedAt());
			return course;

		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public Course updateCourse(Course course, int id) {
		try {
			Course original = courseJpaRepository.findById(id).get();
			if (course.getTitle() != null) {
				original.setTitle(course.getTitle());
			}
			if (course.getDescription() != null) {
				original.setDescription(course.getDescription());
			}
			if (course.getAuthor() != null) {
				int userId = course.getAuthor().getUserId();

				original.setAuthor(userJpaRepository.findById(userId).get());
			}
			if (course.getCategory() != null) {

				int catId = course.getCategory().getCategoryId();
				int orgId = original.getCategory().getCategoryId();
				if (orgId != catId) {
					Category orginalCategory = categoryJpaRepository.findById(orgId).get();
					orginalCategory.getCourses().remove(original);
					categoryJpaRepository.save(orginalCategory);
				}

				Category category = categoryJpaRepository.findById(catId).get();
				original.setCategory(category);
				category.getCourses().add(course);
				categoryJpaRepository.save(category);
			}

			if (course.getSections() != null) {
				List<Section> sections = course.getSections();
				List<Integer> sectionIds = new ArrayList<>();

				for (Section section : sections) {
					sectionIds.add(section.getSectionId());
				}
				original.setSections(sectionJpaRepository.findAllById(sectionIds));
			}
			if (course.getEnrolledUsers() != null) {
				List<User> enrolledUsers = course.getEnrolledUsers();
				List<Integer> enrolledUserIds = new ArrayList<>();

				for (User enrolledUser : enrolledUsers) {
					enrolledUserIds.add(enrolledUser.getUserId());
				}
				original.setEnrolledUsers(userJpaRepository.findAllById(enrolledUserIds));
			}
			courseJpaRepository.save(original);
			return original;
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public void deleteCourse(int id) {
		try {
			Course course = courseJpaRepository.findById(id).get();
			Category orginalCategory = categoryJpaRepository.findById(course.getCategory().getCategoryId()).get();
			orginalCategory.getCourses().remove(course);
			categoryJpaRepository.save(orginalCategory);
			courseJpaRepository.deleteById(id);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);

		}
	}

	@Override
	public String enrollingStudent(int studentId, int courseId) {

		try {
			User studentUser = userJpaRepository.findById(studentId).get();
			Course course = courseJpaRepository.findById(courseId).get();
			course.getEnrolledUsers().add(studentUser);
			courseJpaRepository.save(course);
			studentUser.getEnrolledCourses().add(course);
			userJpaRepository.save(studentUser);
			return "user enrolled successfully";
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}

	}

}
