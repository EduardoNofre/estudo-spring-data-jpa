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
import com.estudo.jpa.service.JpaEstudoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "/v1/jpa", description = " JPA ESTUDO ")
@RestController
@RequestMapping("/jpa-estudo-controller-app")
public class JpaEstudoController {

	@Autowired
	private JpaEstudoService jpaEstudoService;
	
	@GetMapping(value = "/getMethodJPAbusca/id/{id}")
	@ApiOperation(value = "Busca utilizando jpa repository simples", response = ResponseEntity.class)
	public ResponseEntity<JpaEstudoDto>  getMethodJPA(@PathVariable Long id) {

		return new ResponseEntity<JpaEstudoDto>(jpaEstudoService.jpaBusca(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getMethodJPANativeQuery/id/{id}/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca utilizando native query ", response = ResponseEntity.class)
	public ResponseEntity<List<JpaEstudoDto>> getMethodJPANativeQuery(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return new ResponseEntity<List<JpaEstudoDto>>(jpaEstudoService.jpaNativeQuery(id, nome, idade, cidade, telefone), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getMethodJPAQuery/id/{id}/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca utilizando @Query", response = ResponseEntity.class)
	public ResponseEntity<List<JpaEstudoDto>>  getMethodJPAQuery(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return new ResponseEntity<List<JpaEstudoDto>>(jpaEstudoService.jpaQuery(id, nome, idade, cidade, telefone), HttpStatus.OK);

	}

	@GetMapping(value = "/getMethodJPACritiria/id/{id}/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca utilizando Critiria ", response = ResponseEntity.class)
	public ResponseEntity<?>  getMethodJPACritiria(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return null;
	}
	
	@GetMapping(value = "/getMethodJPASpec/id/{id}/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca utilizando specification jpa ", response = ResponseEntity.class)
	public ResponseEntity<?>  getMethodJPASpec(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return null;
	}
	
	@GetMapping(value = "/getMethodJPAprojection/id/{id}/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Busca utilizando specification jpa ", response = ResponseEntity.class)
	public ResponseEntity<?>getMethodJPAprojection(@PathVariable Long id, @PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return null;
	}

	@PutMapping(value = "/putMethodJPASpec/nome{nome}/idade{idade}/cidade{cidade}/telefone{telefone}")
	@ApiOperation(value = "Save basico ", response = ResponseEntity.class)
	public ResponseEntity<JpaEstudoDto>  putMethodJPASave(@PathVariable String nome, @PathVariable int idade, @PathVariable String cidade, @PathVariable String telefone) {

		return new ResponseEntity<>(jpaEstudoService.jpaSave(nome, idade, cidade, telefone), HttpStatus.OK);
	}	
}
