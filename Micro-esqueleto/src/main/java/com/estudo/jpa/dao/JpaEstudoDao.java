package com.estudo.jpa.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.estudo.jpa.entity.JpaEstudoEntity;

@Repository
 public interface JpaEstudoDao {

	List<JpaEstudoEntity> jpaDaoBusca(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade);

	List<JpaEstudoEntity> jpaNativeQueryDaoBusca(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade);

	List<JpaEstudoEntity> jpaQueryDaoBusca(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade);

	List<JpaEstudoEntity> jpaCritiriaDaoBusca(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade);

	List<JpaEstudoEntity> jpaSpecDaoBusca(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade);

	JpaEstudoEntity jpaSaveDao(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade);
}
