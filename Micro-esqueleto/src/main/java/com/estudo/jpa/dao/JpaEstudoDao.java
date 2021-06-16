package com.estudo.jpa.dao;

import java.util.List;
import java.util.Optional;

import com.estudo.jpa.dto.JpaEstudoDto;
import com.estudo.jpa.entity.JpaEstudoEntity;
import com.estudo.jpa.spec.JpaEstudoCidadeLikeSpec;
import com.estudo.jpa.spec.JpaEstudoNomeLikeSpec;


public interface JpaEstudoDao {

	Optional<JpaEstudoEntity> jpaDaoBusca(Long id);

	List<JpaEstudoDto> jpaNativeQueryDaoBusca(JpaEstudoEntity jpaEstudoEntity);

	List<JpaEstudoEntity> jpaQueryJpqlDaoBusca1(Long id, String nome, int idade, String cidade, String telefone);
	
	List<JpaEstudoEntity> jpaQueryJpqlDaoBusca2(Long id, String nome, int idade, String cidade, String telefone);
	
	List<JpaEstudoEntity> jpaXMLDaoBusca(Long id, String nome, int idade, String cidade, String telefone);
	
	List<JpaEstudoEntity> jpaImplDaoRepository(Long id, String nome, int idade, String cidade, String telefone);
	
	List<JpaEstudoEntity> jPAQueryDaoDinamicaBusca(Long id, String nome, int idade, String cidade, String telefone);	

	List<JpaEstudoEntity> jpaCritiriaDaoBusca(Long id, String nome, int idade, String cidade, String telefone);
	
	List<JpaEstudoEntity> jPACritiriaDaoDinamicaBusca(Long id, String nome, int idade, String cidade, String telefone);
	
	List<JpaEstudoEntity> jpaDaoSpecBusca(JpaEstudoNomeLikeSpec nomeSpec, JpaEstudoCidadeLikeSpec cidadeSpec);	
	
	List<Object[]> jpaDaoProjection(String nome, String cidade);

	JpaEstudoEntity jpaSaveDao(JpaEstudoEntity jpaEstudoEntity);
	
	boolean jpaExisteDao(Long id);
}
