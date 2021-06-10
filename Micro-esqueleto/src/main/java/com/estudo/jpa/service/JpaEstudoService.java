package com.estudo.jpa.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import com.estudo.jpa.dao.JpaEstudoDao;
import com.estudo.jpa.dto.JpaEstudoDto;
import com.estudo.jpa.entity.JpaEstudoEntity;

@org.springframework.stereotype.Service
public class JpaEstudoService {

	@Autowired
	private JpaEstudoDao jpaEstudoDao;

	@Autowired
	private ModelMapper modelMapper;


	/**
	 * 
	 * Este metodo usa o findbyid do repositorio  
	 * 
	 * @param id
	 * @return
	 */
	public JpaEstudoDto jpaBusca(Long id) {

		return modelMapper.map(jpaEstudoDao.jpaDaoBusca(id).get(), JpaEstudoDto.class);
	}

	/**
	 * 
	 * Aqui iremos utilizar um query normal 
	 * 
	 * @param id
	 * @param nome
	 * @param idade
	 * @param cidade
	 * @param telefone
	 * @return
	 */
	public List<JpaEstudoDto> jpaNativeQuery(Long id, String nome, int idade, String cidade, String telefone) {

		JpaEstudoDto jpaEstudoDto = new JpaEstudoDto();
		jpaEstudoDto.setNome(nome);
		jpaEstudoDto.setIdade(idade);
		jpaEstudoDto.setCidade(cidade);
		jpaEstudoDto.setTelefone(telefone);

		return jpaEstudoDao.jpaNativeQueryDaoBusca(modelMapper.map(jpaEstudoDto, JpaEstudoEntity.class));
	}

	public List<JpaEstudoDto> jpaQuery(Long id, String nome, int idade, String cidade, String telefone) {

		List<JpaEstudoEntity> listJpaEstudoEntity = jpaEstudoDao.jpaQueryDaoBusca(id, nome, idade, cidade, telefone);
		return modelMapper.map(listJpaEstudoEntity, new TypeToken<List<JpaEstudoDto>>() {}.getType());
	}

	public List<JpaEstudoEntity> jpaCritiria(Long id, String nome, int idade, String cidade, String telefone) {

		return null;
	}

	public List<JpaEstudoEntity> jpaSpec(Long id, String nome, int idade, String cidade, String telefone) {

		return null;
	}
	
	public List<JpaEstudoEntity> jpaJpql(Long id, String nome, int idade, String cidade, String telefone) {

		return null;
	}

	public JpaEstudoDto jpaSave(String nome, int idade, String cidade, String telefone) {

		JpaEstudoDto jpaEstudoDto = new JpaEstudoDto();
		jpaEstudoDto.setNome(nome);
		jpaEstudoDto.setIdade(idade);
		jpaEstudoDto.setCidade(cidade);
		jpaEstudoDto.setTelefone(telefone);
		JpaEstudoEntity jpaEstudoEntity = jpaEstudoDao.jpaSaveDao(modelMapper.map(jpaEstudoDto, JpaEstudoEntity.class));
		return modelMapper.map(jpaEstudoEntity, JpaEstudoDto.class);
	}

}
