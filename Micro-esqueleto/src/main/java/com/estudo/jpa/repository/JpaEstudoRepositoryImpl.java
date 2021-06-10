package com.estudo.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

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
	
}
