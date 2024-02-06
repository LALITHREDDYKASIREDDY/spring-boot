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

import com.example.LearningPortal.model.Section;
import com.example.LearningPortal.service.SectionService;

@RestController
public class SectionController {
	@Autowired
	SectionService sectionService;

	@GetMapping("/courses/sections")
	public ArrayList<Section> getSections() {
		return sectionService.getSections();
	}

	@GetMapping("/courses/sections/{sectionId}")
	public Section getSectionById(@PathVariable("sectionId") int id) {
		return sectionService.getSectionById(id);
	}

	@PostMapping("/courses/sections")
	public Section createSection(@RequestBody Section section) {
		return sectionService.addSection(section);
	}

	@PutMapping("/courses/sections/{sectionId}")
	public Section updateSection(@PathVariable("sectionId") int id, @RequestBody Section section) {
		return sectionService.updateSection(id, section);
	}

	@DeleteMapping("/courses/sections/{sectionId}")
	public void deleteSection(@PathVariable("sectionId") int id) {
		sectionService.deleteSectionById(id);
	}

}
