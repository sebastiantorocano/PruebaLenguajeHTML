package com.example.PruebaLenguajeHTML.controller;




import com.example.PruebaLenguajeHTML.model.LanguageModel;
import com.example.PruebaLenguajeHTML.repository.LanguageRepository;
import com.example.PruebaLenguajeHTML.utils.Utils;


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
	@GetMapping("/language")
	public List<LanguageModel> getAllNotes() {
		return languageRepository.findAll();
	}
	
	@PostMapping("/language")
	public LanguageModel createNote(@Valid @RequestBody LanguageModel language) {
		return languageRepository.save(language);
	}
	
	@PostMapping("/languageSimbol")
	public String getLanguaje(@RequestParam(value="word") String word) {
		
		List<LanguageModel> language=languageRepository.findAll();
		
		Utils util= new Utils();
		
		

		word = word.trim();
		String[] arrayWord = word.split(" ");
		String simb = arrayWord[0].charAt(0) + "";

		

		return util.validationSimbol(languageRepository.findBySimbol(simb), arrayWord);
		
		
	}


}
