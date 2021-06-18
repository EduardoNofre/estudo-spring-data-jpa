package com.estudo.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estudo.jpa.dto.JpaEstudoDto;
import com.estudo.jpa.projections.JpaEstudoProjections;
import com.estudo.jpa.service.JpaEstudoService;
import com.estudo.jpa.spec.JpaEstudoCidadeLikeSpec;
import com.estudo.jpa.spec.JpaEstudoNomeLikeSpec;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/v1/jpa", description = " JPA ESTUDO ")
@RestController
@RequestMapping("/jpa-estudo-controller-app")
public class JpaEstudoController {

	@Autowired
	private JpaEstudoService jpaEstudoService;
	
	@GetMapping(value = "/JPAbusca/id/{id}")
	@ApiOperation(value = "Busca utilizando jpa repository simples", response = ResponseEntity.class)
	public ResponseEntity<JpaEstudoDto>  jPA(@PathVariable Long id) {

		return new ResponseEntity<JpaEstudoDto>(jpaEstudoService.jpaBusca(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/JPANativeQuery/id/{id}/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca utilizando native query ", response = ResponseEntity.class)
	public ResponseEntity<List<JpaEstudoDto>> jPANativeQuery(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return new ResponseEntity<List<JpaEstudoDto>>(jpaEstudoService.jpaNativeQueryJpql(id, nome, idade, cidade, telefone), HttpStatus.OK);
	}
	
	@GetMapping(value = "/JPAQuery1/id/{id}/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca utilizando @Query exemplo 1", response = ResponseEntity.class)
	public ResponseEntity<List<JpaEstudoDto>>  jPAQueryJpql1(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return new ResponseEntity<List<JpaEstudoDto>>(jpaEstudoService.jpaQueryJpql1(id, nome, idade, cidade, telefone), HttpStatus.OK);

	}
	
	@GetMapping(value = "/JPAQuery2/id/{id}/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca utilizando @Query exemplo 2", response = ResponseEntity.class)
	public ResponseEntity<List<JpaEstudoDto>>  JPAQueryJpql2(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return new ResponseEntity<List<JpaEstudoDto>>(jpaEstudoService.jpaQueryJpql2(id, nome, idade, cidade, telefone), HttpStatus.OK);

	}
	
	@GetMapping(value = "/JPAXML/id/{id}/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca utilizando XML ", response = ResponseEntity.class)
	public ResponseEntity<List<JpaEstudoDto>>  jPAXML(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return new ResponseEntity<List<JpaEstudoDto>>(jpaEstudoService.jpaXML(id, nome, idade, cidade, telefone), HttpStatus.OK);
	}

	@GetMapping(value = "/implRepository/id/{id}/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca implementendo repository ", response = ResponseEntity.class)
	public ResponseEntity<List<JpaEstudoDto>>  jPAImplementendoRepository(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return new ResponseEntity<List<JpaEstudoDto>>(jpaEstudoService.jPAImplementandoRepository(id, nome, idade, cidade, telefone), HttpStatus.OK);
	}
	
	@GetMapping(value = "/jPAQueryDinamica/id/{id}/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca utilizando Exemplo 1 query dinamica ", response = ResponseEntity.class)
	public ResponseEntity<List<JpaEstudoDto>>  jPAQueryDinamica(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return new ResponseEntity<List<JpaEstudoDto>>(jpaEstudoService.jPAQueryDinamica(id, nome, idade, cidade, telefone), HttpStatus.OK);
	}
	
	
	@GetMapping(value = "/JPACritiria/id/{id}/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca utilizando Critiria exemplo simples", response = ResponseEntity.class)
	public ResponseEntity<List<JpaEstudoDto>>  jPACritiria(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return new ResponseEntity<List<JpaEstudoDto>>(jpaEstudoService.jpaCriteria(id, nome, idade, cidade, telefone), HttpStatus.OK);

	}
	
	@GetMapping(value = "/jPACritiriaDinamica/id/{id}/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca utilizando Critiria montagem dinamica", response = ResponseEntity.class)
	public ResponseEntity<List<JpaEstudoDto>>jPACritiriaDinamica(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return new ResponseEntity<List<JpaEstudoDto>>(jpaEstudoService.jPACritiriaDinamica(id, nome, idade, cidade, telefone), HttpStatus.OK);
	}
	
	@GetMapping(value = "/JPASpec/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca utilizando specification jpa", response = ResponseEntity.class)
	public ResponseEntity<List<JpaEstudoDto>>JPASpec(@PathVariable String nome, @PathVariable String cidade) {

		JpaEstudoNomeLikeSpec nomeSpec = new JpaEstudoNomeLikeSpec(nome);
		JpaEstudoCidadeLikeSpec cidadeSpec = new JpaEstudoCidadeLikeSpec(cidade);		
		return new ResponseEntity<List<JpaEstudoDto>>(jpaEstudoService.jpaSpec(nomeSpec, cidadeSpec), HttpStatus.OK);
		
	}
	
	@GetMapping(value = "/JPAprojection/id/{id}/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca utilizando projection jpa  ", response = ResponseEntity.class)
	public ResponseEntity<List<JpaEstudoDto>>jpaProjection(@PathVariable String nome, @PathVariable String cidade) {

		return new ResponseEntity<List<JpaEstudoDto>>(jpaEstudoService.jpaProjection(nome, cidade), HttpStatus.OK);
	}
	
	
	@PutMapping(value = "/save/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Save basico ", response = ResponseEntity.class)
	public ResponseEntity<JpaEstudoDto>jPASave(@PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return new ResponseEntity<>(jpaEstudoService.jpaSave(nome, idade, cidade, telefone), HttpStatus.OK);
	}	
	
}
