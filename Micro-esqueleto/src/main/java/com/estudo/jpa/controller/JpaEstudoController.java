package com.estudo.jpa.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "/v1/jpa", description = " JPA ESTUDO ")
@RestController
@Validated
@RequestMapping("/finance-app")
public class JpaEstudoController {

	
	@GetMapping(value = "path")
	public void getMethodJPA(@RequestParam String param) {

	}
	
	@GetMapping(value = "path")
	public void getMethodJPANativeQuery(@RequestParam String param) {

	}
	
	@GetMapping(value = "path")
	public void getMethodJPAQuery(@RequestParam String param) {

	}

	@GetMapping(value = "path")
	public void getMethodJPACritiria(@RequestParam String param) {

	}

	@PutMapping(value = "path/{id}")
	public void putMethodJPASpec(@PathVariable String id) {

	}	
}
