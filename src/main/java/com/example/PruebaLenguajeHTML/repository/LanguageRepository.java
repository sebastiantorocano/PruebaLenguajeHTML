package com.example.PruebaLenguajeHTML.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.PruebaLenguajeHTML.model.LanguageModel;



@Repository
public interface LanguageRepository extends JpaRepository<LanguageModel, Long>{

}
