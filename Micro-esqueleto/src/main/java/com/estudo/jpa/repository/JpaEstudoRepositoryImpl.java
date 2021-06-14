package com.estudo.jpa.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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


	public List<JpaEstudoEntity> buscaJpaCritiria(String nome, int idade, String cidade) {

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<JpaEstudoEntity> criteria = builder.createQuery(JpaEstudoEntity.class);

		Root<JpaEstudoEntity> root = criteria.from(JpaEstudoEntity.class);

		Predicate nomeProperties = builder.like(root.get("nome"),"%"+nome+"%");

		criteria.where(nomeProperties);

		TypedQuery<JpaEstudoEntity> query = entityManager.createQuery(criteria);

		return query.getResultList();
	}


	public List<JpaEstudoEntity> jPACritiriaDinamica(String nome, int idade, String cidade){

		CriteriaBuilder builder = entityManager.getCriteriaBuilder();

		CriteriaQuery<JpaEstudoEntity> criteria = builder.createQuery(JpaEstudoEntity.class);

		Root<JpaEstudoEntity> root = criteria.from(JpaEstudoEntity.class);

		List<Predicate> predicateList = new ArrayList<Predicate>();

		if(StringUtils.hasText(nome)) {

			predicateList.add(builder.like(root.get("nome"),"%"+nome+"%"));
		}

		if(idade != 0) {
			predicateList.add(builder.ge(root.get("idade"),idade));
		}

		if(StringUtils.hasText(nome)) {

			predicateList.add(builder.like(root.get("cidade"),"%"+cidade+"%"));
		}

		criteria.where(predicateList.toArray(new Predicate[0]));

		TypedQuery<JpaEstudoEntity> query = entityManager.createQuery(criteria);

		return query.getResultList();
	}

}
