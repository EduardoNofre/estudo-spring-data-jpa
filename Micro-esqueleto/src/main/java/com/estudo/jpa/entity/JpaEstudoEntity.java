package com.estudo.jpa.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@javax.persistence.Entity
@Data
@Table(name = "JpaEstudoEntity")
public class JpaEstudoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private Long id;
	private String nome;
	private int idade;
	private String cidade;
	private String telefone;
}
