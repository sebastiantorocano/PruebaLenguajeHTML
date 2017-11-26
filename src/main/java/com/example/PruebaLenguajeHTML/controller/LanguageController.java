package com.example.PruebaLenguajeHTML.controller;




import com.example.PruebaLenguajeHTML.model.LanguageModel;
import com.example.PruebaLenguajeHTML.repository.LanguageRepository;
import com.example.PruebaLenguajeHTML.utils.Utils;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


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
		String completeHtml="";
		
		Utils util= new Utils();
		List<String> wordsList=util.distributeWords(word, language);
		
		List<String> labelHtmlArray=new  ArrayList<String>();
		
		for(int j=0;j<wordsList.size();j++) {
			String wordProccess=wordsList.get(j).replace("-", " ");
			wordProccess = wordProccess.trim();
			String[] arrayWord = wordProccess.split(" ");
			String simb = arrayWord[0].charAt(0) + "";
			
		String labelHtml=	util.validationSimbol(languageRepository.findBySimbol(simb), arrayWord);
		labelHtmlArray.add(labelHtml);
		}
		
		 completeHtml = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"utf-8\">\r\n"

				+ "<title></title>\r\n" + "</head>\r\n" + "<body>\r\n";
		 
		for(int i=0;i<labelHtmlArray.size();i++) {
			completeHtml=completeHtml+labelHtmlArray.get(i)+"\r\n";
		}
		
		
		completeHtml = completeHtml + "</body>\r\n" + "</html>";
		
		

		

		

		return completeHtml;
		
		
	}


}
