package com.example.upload.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {
	@PostMapping("/upload")
	public String getMethodName(@RequestParam("file") MultipartFile file) {

		try {

			System.out.println(file.getOriginalFilename());
			File f = new File("C:\\Users\\Dell\\Desktop\\spring-boot\\spring-boot\\upload\\uploads\\"
					+ file.getOriginalFilename());
			if (!f.exists()) {
				f.createNewFile();
			}
			;
			FileOutputStream fos = new FileOutputStream(f);
			fos.write(file.getBytes());
			fos.close();
		} catch (Exception e) {
			System.out.println("an exception ocured");
		}
		return "file uploaded";
	}

	@PostMapping("/upload/uploadPdf")
	public String uploadingPDF(@RequestParam("file") MultipartFile file) {

		try {

			File f = new File("C:\\Users\\Dell\\Desktop\\spring-boot\\spring-boot\\upload\\uploads\\"
					+ file.getOriginalFilename());

			if (!file.getName().endsWith("pdf")) {
				return "only pdf files are allowed";
			}
			if (!f.exists()) {
				f.createNewFile();
			}
			;

			FileOutputStream fos = new FileOutputStream(f);
			fos.write(file.getBytes());
		} catch (Exception e) {
			System.out.println("an exception ocured");
		}
		return "file uploaded";
	}

	@GetMapping("/upload/{fileName}")
	public ResponseEntity getMethodName(@PathVariable("fileName") String fileName) {
		try {
			String path = "C:\\Users\\Dell\\Desktop\\spring-boot\\spring-boot\\upload\\uploads";
			File obj = new File(path);
			String[] fileNames = obj.list();
			boolean contains = false;
			for (String s : fileNames) {
				if (s.equals(fileName)) {
					contains = true;
				}
			}

			if (!contains) {
				throw new Exception();
			}
			path += "\\" + fileName;
			File org = new File(path);
			FileInputStream fis = new FileInputStream(org);
			InputStreamResource resource = new InputStreamResource(fis);

			String contentType = "application/pdf";
			String headerValue = "attachment; filename=\"" + fileName + "\"";
			System.out.println("this is filename" + org.getName());
			return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
					.header(HttpHeaders.CONTENT_DISPOSITION, headerValue).body(resource);
		} catch (Exception e) {
			System.out.println("in catch");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	@GetMapping("/upload2/{fileName}")
	public ResponseEntity get(@PathVariable("fileName") String fileName) {
		try {
			String path = "C:\\Users\\Dell\\Desktop\\spring-boot\\spring-boot\\upload\\uploads";
			File obj = new File(path);
			String[] fileNames = obj.list();
			boolean contains = false;
			for (String s : fileNames) {
				if (s.equals(fileName)) {
					contains = true;
				}
			}

			if (!contains) {
				throw new Exception();
			}
			path += "\\" + fileName;
			File org = new File(path);
			FileInputStream fis = new FileInputStream(org);
			InputStreamResource resource = new InputStreamResource(fis);

			String contentType = "application/pdf";
			String headerValue = "attachment; filename=\"" + resource.getFilename() + "\"";

			return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
					.header(HttpHeaders.CONTENT_DISPOSITION, headerValue).body(resource);
		} catch (Exception e) {
			System.out.println("in catch");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}
