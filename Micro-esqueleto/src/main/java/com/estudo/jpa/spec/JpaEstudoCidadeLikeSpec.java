package com.estudo.jpa.spec;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.estudo.jpa.entity.JpaEstudoEntity;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class JpaEstudoCidadeLikeSpec implements Specification<JpaEstudoEntity> {

	private static final long serialVersionUID = 1L;
	private String cidade;

	@Override
	public Predicate toPredicate(Root<JpaEstudoEntity> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

		return criteriaBuilder.like(root.get("cidade"), "%" + cidade + "%");
	}
}
