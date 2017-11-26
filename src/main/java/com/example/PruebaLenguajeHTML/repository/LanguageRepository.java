package com.example.PruebaLenguajeHTML.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.PruebaLenguajeHTML.model.LanguageModel;



@Repository
public interface LanguageRepository extends JpaRepository<LanguageModel, Long>{

	List<LanguageModel> findBySimbol(@Param("simbol") String simb);
}
