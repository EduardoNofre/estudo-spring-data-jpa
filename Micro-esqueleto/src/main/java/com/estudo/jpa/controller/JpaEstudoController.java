package com.estudo.jpa.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "/v1/jpa", description = " JPA ESTUDO ")
@RestController
@Validated
@RequestMapping("/jpa-estudo-controller-app")
public class JpaEstudoController {

	
	@GetMapping(value = "getMethodJPA")
	public void getMethodJPA(@PathVariable Long id, @PathVariable String nome,@PathVariable int idade) {

	}
	
	@GetMapping(value = "/getMethodJPANativeQuery/{id}/nome{nome}/idade{idade}")
	public void getMethodJPANativeQuery(@PathVariable Long id, @PathVariable String nome,@PathVariable int idade) {

	}
	
	@GetMapping(value = "/getMethodJPAQuery/{id}/nome{nome}/idade{idade}")
	public void getMethodJPAQuery(@PathVariable Long id, @PathVariable String nome,@PathVariable int idade) {

	}

	@GetMapping(value = "/getMethodJPACritiria/{id}/nome{nome}/idade{idade}")
	public void getMethodJPACritiria(@PathVariable Long id, @PathVariable String nome,@PathVariable int idade) {

	}
	
	@GetMapping(value = "/getMethodJPASpec/{id}/nome{nome}/idade{idade}")
	public void getMethodJPASpec(@PathVariable Long id, @PathVariable String nome,@PathVariable int idade) {

	}

	@PutMapping(value = "/putMethodJPASpec/{id}/nome{nome}/idade{idade}")
	public void putMethodJPASave(@PathVariable Long id, @PathVariable String nome,@PathVariable int idade) {

	}	
}
