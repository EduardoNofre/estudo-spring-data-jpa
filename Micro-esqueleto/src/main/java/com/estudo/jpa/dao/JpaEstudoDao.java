package com.estudo.jpa.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.estudo.jpa.dto.JpaEstudoDto;
import com.estudo.jpa.entity.JpaEstudoEntity;

@Repository
public interface JpaEstudoDao {

	Optional<JpaEstudoEntity> jpaDaoBusca(Long id);

	List<JpaEstudoDto> jpaNativeQueryDaoBusca(JpaEstudoEntity jpaEstudoEntity);

	List<JpaEstudoEntity> jpaQueryJpqlDaoBusca1(Long id, String nome, int idade, String cidade, String telefone);
	
	List<JpaEstudoEntity> jpaQueryJpqlDaoBusca2(Long id, String nome, int idade, String cidade, String telefone);
	
	List<JpaEstudoEntity> jpaXMLDaoBusca(Long id, String nome, int idade, String cidade, String telefone);
	
	List<JpaEstudoEntity> jpaImpl_Repository(Long id, String nome, int idade, String cidade, String telefone);
	
	List<JpaEstudoEntity> jPAQueryDinamica(Long id, String nome, int idade, String cidade, String telefone);	

	List<JpaEstudoEntity> jpaCritiriaDaoBusca(Long id, String nome, int idade, String cidade, String telefone);

	List<JpaEstudoEntity> jpaSpecDaoBusca(Long id, String nome, int idade, String cidade, String telefone);

	JpaEstudoEntity jpaSaveDao(JpaEstudoEntity jpaEstudoEntity);
	
	boolean jpaExisteDao(Long id);
}
