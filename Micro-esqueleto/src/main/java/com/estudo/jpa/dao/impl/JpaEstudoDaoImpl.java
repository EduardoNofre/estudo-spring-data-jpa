package com.estudo.jpa.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.estudo.jpa.dao.JpaEstudoDao;
import com.estudo.jpa.dto.JpaEstudoDto;
import com.estudo.jpa.entity.JpaEstudoEntity;
import com.estudo.jpa.repository.JpaEstudoRepository;
import com.estudo.jpa.spec.JpaEstudoCidadeLikeSpec;
import com.estudo.jpa.spec.JpaEstudoNomeLikeSpec;

@Repository
public class JpaEstudoDaoImpl implements JpaEstudoDao {

	@Autowired
	private JpaEstudoRepository jpaEstudoRepository;
	
	 @PersistenceContext
	 protected EntityManager entityManager;

	@Override
	public Optional<JpaEstudoEntity> jpaDaoBusca(Long id) {
		return jpaEstudoRepository.findById(id);

	}

	@Override
	public List<JpaEstudoDto> jpaNativeQueryDaoBusca(JpaEstudoEntity jpaEstudoEntity) {
		
		StringBuilder query = new StringBuilder();
		query.append("select id, nome, cidade, idade,  telefone from ");
		query.append(" jpa_estudo_entity  ");
		query.append(" where ");
		query.append(" nome = '" + jpaEstudoEntity.getNome()+"'");
		query.append(" AND idade = " + jpaEstudoEntity.getIdade());
		query.append(" AND cidade = '" + jpaEstudoEntity.getCidade()+"'");
		
		@SuppressWarnings("unchecked")
		List<Object[]> listaNative =  entityManager.createNativeQuery(query.toString()).getResultList();
		
		List<JpaEstudoDto> jpaEstudoDtoArray = new ArrayList<JpaEstudoDto>();
		
		for(Object[] obj :listaNative ) {
			 
			JpaEstudoDto jpaEstudoDto = new JpaEstudoDto();
			jpaEstudoDto.setId(Long.valueOf(obj[0].toString()));
			jpaEstudoDto.setNome(obj[1].toString());
			jpaEstudoDto.setCidade(obj[2].toString());
			jpaEstudoDto.setIdade(Integer.valueOf(obj[3].toString()));
			jpaEstudoDto.setTelefone(obj[4].toString());
			jpaEstudoDtoArray.add(jpaEstudoDto);
		}

		return jpaEstudoDtoArray;
	}

	@Override
	public List<JpaEstudoEntity> jpaQueryJpqlDaoBusca1(Long id, String nome, int idade, String cidade, String telefone) {
		return jpaEstudoRepository.buscatodosJpqlQuery1(nome,idade,cidade);
	}
	
	@Override
	public List<JpaEstudoEntity> jpaQueryJpqlDaoBusca2(Long id, String nome, int idade, String cidade, String telefone) {
		return jpaEstudoRepository.buscatodosJpqlQuery2(nome,idade,cidade);
	}

	@Override
	public List<JpaEstudoEntity> jpaXMLDaoBusca(Long id, String nome, int idade, String cidade, String telefone) {
		return jpaEstudoRepository.buscatodosXMl(nome, idade, cidade);
	}
	
		
	@Override
	public List<JpaEstudoEntity> jpaImplDaoRepository(Long id, String nome, int idade, String cidade, String telefone) {
		return jpaEstudoRepository.jpaImplRepository(nome, idade, cidade);
	}

	
	@Override
	public List<JpaEstudoEntity> jPAQueryDaoDinamicaBusca(Long id, String nome, int idade, String cidade, String telefone) {
		return jpaEstudoRepository.jpaQueryDinamica(nome, idade, cidade);
	}

	@Override
	public List<JpaEstudoEntity> jpaCritiriaDaoBusca(Long id, String nome, int idade, String cidade, String telefone) {
		return jpaEstudoRepository.buscaJpaCritiria(nome, idade, cidade);

	}
	
	@Override
	public List<JpaEstudoEntity> jPACritiriaDaoDinamicaBusca(Long id, String nome, int idade, String cidade,String telefone) {
		return jpaEstudoRepository.jPACritiriaDinamica(nome, idade, cidade);
	}

	@Override
	public List<JpaEstudoEntity> jpaDaoSpecBusca(JpaEstudoNomeLikeSpec nomeSpec, JpaEstudoCidadeLikeSpec cidadeSpec) {
		return jpaEstudoRepository.findAll(nomeSpec.and(cidadeSpec));
	}

	@Override
	public JpaEstudoEntity jpaSaveDao(JpaEstudoEntity jpaEstudoEntity) {
		return jpaEstudoRepository.save(jpaEstudoEntity);
	}
	
	@Override
	public List<Object[]> jpaDaoProjection(String nome, String cidade) {
		
		return jpaEstudoRepository.buscaNomeCidade(nome, cidade);
	}

	@Override
	public boolean jpaExisteDao(Long id) {
		if (jpaEstudoRepository.findById(id).isPresent()) {

			return true;
		}

		return false;
	}
}
