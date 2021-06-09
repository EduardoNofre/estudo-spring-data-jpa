package com.estudo.jpa.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@Api(value = "/v1/categoria", description = "RESPONSÁBILIDADE GERENCIAR CATEGORIA")
@RestController
@Validated
@RequestMapping("/finance-app")
public class Controller {

}
