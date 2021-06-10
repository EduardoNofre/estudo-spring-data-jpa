package com.estudo.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estudo.jpa.entity.JpaEstudoEntity;

@Repository
public interface JpaEstudoRepository extends JpaRepository<JpaEstudoEntity, Long> {

	@Query(value = "select id, nome, cidade, idade,  telefone from jpa_estudo_entity j  where j.nome = ?1 AND j.idade =?2 AND j.cidade =?3   ",nativeQuery = true)	
	List<JpaEstudoEntity> buscatodosJpqlQuery1(String nome, int idade, String cidade);
	
	
	@Query(" from JpaEstudoEntity  where nome = :nome AND idade = :idade AND cidade = :cidade ")	
	List<JpaEstudoEntity> buscatodosJpqlQuery2(String nome, int idade, String cidade);
	
	List<JpaEstudoEntity> buscatodosXMl(String nome, int idade, String cidade);
	
	List<JpaEstudoEntity> jpaImplRepository(String nome, int idade, String cidade);
	
}
