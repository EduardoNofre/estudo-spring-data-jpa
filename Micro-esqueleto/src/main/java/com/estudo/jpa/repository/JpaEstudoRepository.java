package com.estudo.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.estudo.jpa.entity.JpaEstudoEntity;

@Repository
public interface JpaEstudoRepository extends JpaRepository<JpaEstudoEntity, Long>,JpaSpecificationExecutor<JpaEstudoEntity> {

	@Query(value = "select id, nome, cidade, idade,  telefone from jpa_estudo_entity j  where j.nome = ?1 AND j.idade =?2 AND j.cidade =?3   ", nativeQuery = true)
	List<JpaEstudoEntity> buscatodosJpqlQuery1(String nome, int idade, String cidade);

	@Query(" from JpaEstudoEntity  where nome = :nome AND idade = :idade AND cidade = :cidade ")
	List<JpaEstudoEntity> buscatodosJpqlQuery2(String nome, int idade, String cidade);

	List<JpaEstudoEntity> buscatodosXMl(String nome, int idade, String cidade);

	List<JpaEstudoEntity> jpaImplRepository(String nome, int idade, String cidade);

	List<JpaEstudoEntity> jpaQueryDinamica(String nome, int idade, String cidade);

	List<JpaEstudoEntity> buscaJpaCritiria(String nome, int idade, String cidade);

	List<JpaEstudoEntity> jPACritiriaDinamica(String nome, int idade, String cidade);
	
	@Query(value = "SELECT nome, cidade FROM JPA_ESTUDO_ENTITY  where nome LIKE %:nome%  and cidade like %:cidade% ", nativeQuery = true)
	List<Object[]> buscaNomeCidade(@Param("nome") String name,@Param("cidade") String cidade);

}
