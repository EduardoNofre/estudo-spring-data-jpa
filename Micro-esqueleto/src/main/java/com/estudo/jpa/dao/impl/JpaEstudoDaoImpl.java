package com.estudo.jpa.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.estudo.jpa.dao.JpaEstudoDao;
import com.estudo.jpa.entity.JpaEstudoEntity;
import com.estudo.jpa.repository.JpaEstudoRepository;

public class JpaEstudoDaoImpl implements JpaEstudoDao {

	@Autowired
	private JpaEstudoRepository jpaEstudoRepository;

	@Override
	public List<JpaEstudoEntity> jpaDaoBusca(Long id, String nome, int idade) {

		return null;

	}

	@Override
	public List<JpaEstudoEntity> jpaNativeQueryDaoBusca(Long id, String nome, int idade) {

		return null;

	}

	@Override
	public List<JpaEstudoEntity> jpaQueryDaoBusca(Long id, String nome, int idade) {

		return null;

	}

	@Override
	public List<JpaEstudoEntity> jpaCritiriaDaoBusca(Long id, String nome, int idade) {

		return null;

	}

	@Override
	public List<JpaEstudoEntity> jpaSpecDaoBusca(Long id, String nome, int idade) {

		return null;

	}

	@Override
	public JpaEstudoEntity jpaSaveDao(Long id, String nome, int idade) {

		return null;

	}

}
