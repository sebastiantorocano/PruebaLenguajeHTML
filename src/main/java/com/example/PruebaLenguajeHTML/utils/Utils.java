package com.example.PruebaLenguajeHTML.utils;

import java.util.List;

import com.example.PruebaLenguajeHTML.model.LanguageModel;

public class Utils {

	public String validationSimbol(List<LanguageModel> list, String[] arrayWord) {

		String content = list.get(0).getContent();
		String simbol = list.get(0).getSimbol();
		String word = arrayWord[1];
		int count = arrayWord[0].length();

		String completeHtml = "<!DOCTYPE html>\r\n" + "<html>\r\n" + "<head>\r\n" + "<meta charset=\"utf-8\">\r\n"
				+ "<title></title>\r\n" + "</head>\r\n" + "<body>\r\n";

		if (list.get(0).getSimbol().equals("#")) {
			completeHtml = completeHtml + "<" + content + count + ">" + word + "</" + content + count + ">\r\n";
		} else {
			completeHtml = completeHtml + "<" + content + ">" + word + "</" + content + ">\r\n";
		}

		completeHtml = completeHtml + "</body>\r\n" + "</html>";

		System.out.print("simbol " + simbol + "content " + content + " count " + count + " h " + completeHtml);
		return completeHtml;
	}

	public List<String> distributeWords(String words,List<LanguageModel> language) {
		List<LanguageModel> wordsList;
		
		String simbol = null;
		String wordComplete=null;
		boolean flag=false;
		for (int i = 0; i < words.length(); i++) {
			String c = words.charAt(i)+"";

			for(int j=0;i<language.size();j++) {
				if(c==language.get(j).getSimbol()) {
					flag=true;
					simbol=simbol+c;
				}else {
					flag=false;
					wordComplete=wordComplete+c;
				}
			}
		}
		return null;

	}
}
