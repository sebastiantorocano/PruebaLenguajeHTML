package com.example.PruebaLenguajeHTML.utils;

import java.util.ArrayList;
import java.util.List;

import com.example.PruebaLenguajeHTML.model.LanguageModel;

public class Utils {

	public String validationSimbol(List<LanguageModel> list, String[] arrayWord) {

		String content = list.get(0).getContent();
		String simbol = list.get(0).getSimbol();
		String word = arrayWord[1];
		int count = arrayWord[0].length();

		String completeHtml = "";

		if (list.get(0).getSimbol().equals("#")) {
			completeHtml = completeHtml + "<" + content + count + ">" + word + "</" + content + count + ">\r\n";
		} else {
			completeHtml = completeHtml + "<" + content + ">" + word + "</" + content + ">\r\n";
		}

		System.out.print("simbol " + simbol + "content " + content + " count " + count + " h " + completeHtml);
		return completeHtml;
	}

	public  List<String>  distributeWords(String words,List<LanguageModel> language) {
		 List<String> wordsList = new 	ArrayList<String>();
		
		String simbol = "";
		String wordComplete="";
int countEmpty=0;
		for (int i = 0; i < words.length(); i++) {
			String c = words.charAt(i)+"";
			

			for(int j=0;j<language.size();j++) {
				if(c.equals(language.get(j).getSimbol().trim())) {
					System.out.println("simbolos "+language.get(j).getSimbol().trim());
					
					simbol=simbol+c;
					
				}else {
					
					if(c.equals(" ")) {
						countEmpty++;
						wordComplete=wordComplete+"-";
					}else {
						wordComplete=wordComplete+c;
					}
					
				}
			}
			if(countEmpty>2) {
				wordsList.add(simbol+wordComplete);
				countEmpty=0;
				wordComplete="";
				simbol="";
			}
			
		}
		return wordsList;

	}
}
