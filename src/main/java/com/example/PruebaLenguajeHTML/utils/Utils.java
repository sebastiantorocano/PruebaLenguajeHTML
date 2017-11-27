package com.example.PruebaLenguajeHTML.utils;

import java.util.ArrayList;
import java.util.List;

import com.example.PruebaLenguajeHTML.model.LanguageModel;

public class Utils {

	public String validationSimbol(List<LanguageModel> list, String[] arrayWord) {

		String word ="";
		
		String content = list.get(0).getContent();
		String simbol = list.get(0).getSimbol();
		
		for(int i=1;i<arrayWord.length;i++) {
			 word = word+arrayWord[i]+" ";
		}
		
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

	public boolean countSpaces(String words, List<LanguageModel> language) {
		int spaces = 0;
		int countSimbol=0;
		boolean flag=false;
		for (int i = 0; i < words.length(); i++) {
			String c = words.charAt(i) + "";

			for (int j = 0; j < language.size(); j++) {
				if (c.equals(language.get(j).getSimbol().trim())) {
					countSimbol++;
				}
				
				if(c.equals(" ") && countSimbol>0) {
				spaces++;
				}
				
				
				
			}
		}
		if(countSimbol>0 && spaces==0) {
			flag=true;
		}
		
		

		return flag;
	}

	public List<String> distributeWords(String words, List<LanguageModel> language) {
		List<String> wordsList = new ArrayList<String>();

		String simbol = "";
		String wordComplete = "";
		int countEmpty = 0;
		boolean flag = false;
		for (int i = 0; i < words.length(); i++) {
			String c = words.charAt(i) + "";
			for (int j = 0; j < language.size(); j++) {
				if (c.equals(language.get(j).getSimbol().trim())) {
					System.out.println("simbolos " + language.get(j).getSimbol().trim());

					simbol = simbol + c;
					flag = true;

				} else {

					if (c.equals(" ")) {
						
						countEmpty++;
						wordComplete = wordComplete + "-";
						
						System.out.println("vacio "+wordComplete+" cont "+countEmpty);
					} else {
						wordComplete = wordComplete + c;
					}

				}
			}

			if (countEmpty > 2) {
				wordsList.add(simbol + wordComplete);
				System.out.println("añadir  "+simbol + wordComplete);
				countEmpty = 0;
				wordComplete = "";
				simbol = "";
			}

		}
		return wordsList;

	}
}
