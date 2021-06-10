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

	List<JpaEstudoEntity> jpaQueryDaoBusca(Long id, String nome, int idade, String cidade, String telefone);

	List<JpaEstudoEntity> jpaCritiriaDaoBusca(Long id, String nome, int idade, String cidade, String telefone);

	List<JpaEstudoEntity> jpaSpecDaoBusca(Long id, String nome, int idade, String cidade, String telefone);

	JpaEstudoEntity jpaSaveDao(JpaEstudoEntity jpaEstudoEntity);
	
	boolean jpaExisteDao(Long id);
}