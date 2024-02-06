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

import com.example.LearningPortal.model.Course;
import com.example.LearningPortal.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	CourseService courseService;

	@GetMapping("/courses")
	public ArrayList<Course> getCourses() {
		return courseService.getCourses();
	}

	@GetMapping("/courses/{courseId}")
	public Course getCourseById(@PathVariable("courseId") int id) {
		return courseService.getCourseById(id);
	}

	@PostMapping("/courses")
	public Course addCourse(@RequestBody Course course) {
		System.out.println("in coruse");
		return courseService.addCourse(course);
	}

	@PutMapping("/courses/{courseId}")
	public Course updateCourseById(@PathVariable("courseId") int id, @RequestBody Course course) {
		return courseService.updateCourse(course, id);
	}

	@DeleteMapping("/courses/{courseId}")
	public void deleteCourseById(@PathVariable("courseId") int id) {
		courseService.deleteCourse(id);
	}

	@GetMapping("/courses/{courseId}/users/{userId}")
	public String enrollingUser(@PathVariable("courseId") int courseId, @PathVariable("userId") int userId) {
		return courseService.enrollingStudent(userId, courseId);
	}
}
