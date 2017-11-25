package com.example.PruebaLenguajeHTML.model;


import org.hibernate.validator.constraints.NotBlank;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;


@Entity
@Table(name = "language")
public class LanguageModel implements Serializable {
	
	  @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    @NotBlank
	    private String simbol;
	    
	    
	    @NotBlank
	    private String content;


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getSimbol() {
			return simbol;
		}


		public void setSimbol(String simbol) {
			this.simbol = simbol;
		}


		public String getContent() {
			return content;
		}


		public void setContent(String content) {
			this.content = content;
		}




		
		


		
}
