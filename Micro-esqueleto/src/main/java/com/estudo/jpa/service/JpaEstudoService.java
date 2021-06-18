package com.estudo.jpa.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;

import com.estudo.jpa.dao.JpaEstudoDao;
import com.estudo.jpa.dto.JpaEstudoDto;
import com.estudo.jpa.entity.JpaEstudoEntity;
import com.estudo.jpa.projections.JpaEstudoProjections;
import com.estudo.jpa.spec.JpaEstudoCidadeLikeSpec;
import com.estudo.jpa.spec.JpaEstudoNomeLikeSpec;

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
	public List<JpaEstudoDto> jpaNativeQueryJpql(Long id, String nome, int idade, String cidade, String telefone) {

		JpaEstudoDto jpaEstudoDto = new JpaEstudoDto();
		jpaEstudoDto.setNome(nome);
		jpaEstudoDto.setIdade(idade);
		jpaEstudoDto.setCidade(cidade);
		jpaEstudoDto.setTelefone(telefone);

		return jpaEstudoDao.jpaNativeQueryDaoBusca(modelMapper.map(jpaEstudoDto, JpaEstudoEntity.class));
	}

	/**
	 * 
	 * Usando @Query1 java annotation exemplo 1
	 * @param id
	 * @param nome
	 * @param idade
	 * @param cidade
	 * @param telefone
	 * @return
	 */
	public List<JpaEstudoDto> jpaQueryJpql1(Long id, String nome, int idade, String cidade, String telefone) {

		List<JpaEstudoEntity> listJpaEstudoEntity = jpaEstudoDao.jpaQueryJpqlDaoBusca1(id, nome, idade, cidade, telefone);
		return modelMapper.map(listJpaEstudoEntity, new TypeToken<List<JpaEstudoDto>>() {}.getType());
	}

	/**
	 * 
	 * Usando @Query2 java annotation exemplo 2
	 * @param id
	 * @param nome
	 * @param idade
	 * @param cidade
	 * @param telefone
	 * @return
	 */
	public List<JpaEstudoDto> jpaQueryJpql2(Long id, String nome, int idade, String cidade, String telefone) {

		List<JpaEstudoEntity> listJpaEstudoEntity = jpaEstudoDao.jpaQueryJpqlDaoBusca2(id, nome, idade, cidade, telefone);
		return modelMapper.map(listJpaEstudoEntity, new TypeToken<List<JpaEstudoDto>>() {}.getType());
	}

	/**
	 * 
	 *  Usando Arquivo xml para executar a query
	 * @param id
	 * @param nome
	 * @param idade
	 * @param cidade
	 * @param telefone
	 * @return
	 */
	public List<JpaEstudoDto> jpaXML(Long id, String nome, int idade, String cidade, String telefone) {

		List<JpaEstudoEntity> listJpaEstudoEntityXMl = jpaEstudoDao.jpaXMLDaoBusca(id, nome, idade, cidade, telefone);
		return modelMapper.map(listJpaEstudoEntityXMl, new TypeToken<List<JpaEstudoDto>>() {}.getType());
	}


	/**
	 * Implemtando a uma repository para isso funcionar a sua implementação tem que
	 * ter o mesmo nome da sua repository a diferença é que vc deve colocar no final
	 * do nome Impl
	 * 
	 * Exemplo:
	 * 
	 * JpaEstudoRepository
	 * 
	 * JpaEstudoRepositoryImpl
	 * 
	 * @param id
	 * @param nome
	 * @param idade
	 * @param cidade
	 * @param telefone
	 * @return
	 */
	public List<JpaEstudoDto> jPAImplementandoRepository(Long id, String nome, int idade, String cidade, String telefone) {

		List<JpaEstudoEntity> listJpaEstudoEntityXMl = jpaEstudoDao.jpaImplDaoRepository(id, nome, idade, cidade, telefone);
		return modelMapper.map(listJpaEstudoEntityXMl, new TypeToken<List<JpaEstudoDto>>() {}.getType());
	}

	/**
	 * Exemplo query dinamica
	 * @param id
	 * @param nome
	 * @param idade
	 * @param cidade
	 * @param telefone
	 * @return
	 */

	public List<JpaEstudoDto> jPAQueryDinamica(Long id, String nome, int idade, String cidade, String telefone) {

		List<JpaEstudoEntity> listJpaEstudoEntityXMl = jpaEstudoDao.jPAQueryDaoDinamicaBusca(id, nome, idade, cidade, telefone);
		return modelMapper.map(listJpaEstudoEntityXMl, new TypeToken<List<JpaEstudoDto>>() {}.getType());
	}

	/**
	 * exemplo 1 de Criteria simples
	 * @param id
	 * @param nome
	 * @param idade
	 * @param cidade
	 * @param telefone
	 * @return
	 */
	public List<JpaEstudoDto> jpaCriteria(Long id, String nome, int idade, String cidade, String telefone) {

		List<JpaEstudoEntity> listJpaEstudoEntityXMl = jpaEstudoDao.jpaCritiriaDaoBusca(id, nome, idade, cidade, telefone);
		return modelMapper.map(listJpaEstudoEntityXMl, new TypeToken<List<JpaEstudoDto>>() {}.getType());	
	}

	/**
	 * exemplo 1 de Criteria dinamica
	 * @param id
	 * @param nome
	 * @param idade
	 * @param cidade
	 * @param telefone
	 * @return
	 */
	public List<JpaEstudoDto> jPACritiriaDinamica(Long id, String nome, int idade, String cidade, String telefone) {

		List<JpaEstudoEntity> listJpaEstudoEntityXMl = jpaEstudoDao.jPACritiriaDaoDinamicaBusca(id, nome, idade, cidade, telefone);
		return modelMapper.map(listJpaEstudoEntityXMl, new TypeToken<List<JpaEstudoDto>>() {}.getType());
	}

	/**
	 * Exemplo jpa JpaSpecification exemplo
	 * 
	 * @param nomeSpec
	 * @param cidadeSpec
	 * @return
	 */
	public List<JpaEstudoDto> jpaSpec(JpaEstudoNomeLikeSpec nomeSpec, JpaEstudoCidadeLikeSpec cidadeSpec) {

		List<JpaEstudoEntity> listJpaEstudoEntityXMl = jpaEstudoDao.jpaDaoSpecBusca(nomeSpec,cidadeSpec);		
		return modelMapper.map(listJpaEstudoEntityXMl, new TypeToken<List<JpaEstudoDto>>() {}.getType());
	}
	/**
	 * 
	 * metodo simples para persistncia de dados
	 * 
	 * @param nome
	 * @param idade
	 * @param cidade
	 * @param telefone
	 * @return
	 * 
	 */
	public List<JpaEstudoDto> jpaProjection(String nome,String cidade) {
		
		List<Object[]> arrayObject = jpaEstudoDao.jpaDaoProjection(nome, cidade);	
		
		List<JpaEstudoProjections> children = arrayObject.stream().map(indiceArray -> new JpaEstudoProjections(indiceArray[0].toString(),indiceArray[1].toString())).collect(Collectors.toList());
		
		return modelMapper.map(children, new TypeToken<List<JpaEstudoDto>>() {}.getType());
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
