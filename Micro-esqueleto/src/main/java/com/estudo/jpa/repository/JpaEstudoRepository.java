package com.estudo.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.estudo.jpa.entity.JpaEstudoEntity;

@Repository
public interface JpaEstudoRepository extends JpaRepository<JpaEstudoEntity, Long> {

	@Query(value = "select id, nome, cidade, idade,  telefone from jpa_estudo_entity  where nome = ?1 AND idade =?2 AND cidade =?3   ",nativeQuery = true)	
	List<JpaEstudoEntity> BuscatodosNativeQuery(String nome, int idade, String cidade);
}
