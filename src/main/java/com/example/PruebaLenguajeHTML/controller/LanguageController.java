package com.example.PruebaLenguajeHTML.controller;




import com.example.PruebaLenguajeHTML.model.LanguageModel;
import com.example.PruebaLenguajeHTML.repository.LanguageRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api")
public class LanguageController {
	
	
	@Autowired
	LanguageRepository languageRepository;
	
	

	// Get All Notes
	@GetMapping("/test")
	public List<LanguageModel> getAllNotes() {
		System.out.println("test");
		return languageRepository.findAll();
	}
	
	@PostMapping("/language")
	public LanguageModel createNote(@Valid @RequestBody LanguageModel language) {
		return languageRepository.save(language);
	}


}
