package com.estudo.jpa.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.estudo.jpa.entity.JpaEstudoEntity;

@Repository
public class JpaEstudoRepositoryImpl {

	@PersistenceContext
	private EntityManager entityManager;

	public List<JpaEstudoEntity> jpaImplRepository(String nome, int idade, String cidade){

		String jpql = " from JpaEstudoEntity  where nome = :nome AND idade = :idade AND cidade = :cidade ";

		return entityManager.createQuery(jpql, JpaEstudoEntity.class).setParameter("nome", nome)
				.setParameter("idade", idade)
				.setParameter("cidade", cidade)
				.getResultList();

	}

	public List<JpaEstudoEntity> jpaQueryDinamica(String nome, int idade, String cidade){

		String jpql = " from JpaEstudoEntity  where nome = :nome AND idade = :idade AND cidade = :cidade ";		
		Map<String,Object> parametros = new HashMap<String,Object>();

		if(StringUtils.hasLength(nome)) {
			parametros.put("nome", nome);
		}

		if(idade != 0) {
			parametros.put("idade", idade);
		}

		if(StringUtils.hasLength(cidade)) {
			parametros.put("cidade", cidade);
		}

		TypedQuery<JpaEstudoEntity> query = entityManager.createQuery(jpql, JpaEstudoEntity.class);		
		
		parametros.forEach((chave,valor) -> query.setParameter(chave,valor));
		
		return query.getResultList();
	}
	
	
	public List<JpaEstudoEntity> buscaJpaCritiria() {
		
//		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
//		
//		CriteriaQuery<JpaEstudoEntity> criteria = builder.createQuery(JpaEstudoEntity.class);
//		
//		TypedQuery<JpaEstudoEntity> query = entityManager.createQuery(criteria);
//		
//		return query.getResultList();
		
		return null;

	}

}
