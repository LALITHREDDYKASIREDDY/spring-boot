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

import com.example.LearningPortal.model.SubSection;
import com.example.LearningPortal.service.SubSectionService;

@RestController
public class SubSectionController {

	@Autowired
	SubSectionService subSectionService;

	@GetMapping("/courses/sections/subsections")
	public ArrayList<SubSection> getSubSections() {
		return subSectionService.getSubSections();
	}

	@GetMapping("/courses/sections/subsections/{subSectionId}")
	public SubSection getSubSectionById(@PathVariable("subSectionId") int id) {
		return subSectionService.getSubSectionById(id);
	}

	@PostMapping("/courses/sections/subsections")
	public SubSection createSubSection(@RequestBody SubSection subSection) {
		return subSectionService.addSubSection(subSection);
	}

	@PutMapping("/courses/sections/subsections/{subSectionId}")
	public SubSection updateSubSection(@PathVariable("subSectionId") int id, @RequestBody SubSection subSection) {
		return subSectionService.updateSubSection(id, subSection);
	}

	@DeleteMapping("/courses/sections/subsections/{subSectionId}")
	public void deleteSubSection(@PathVariable("subSectionId") int id) {
		subSectionService.deleteSubSectionById(id);
	}

}
