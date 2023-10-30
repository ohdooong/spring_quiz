package com.quiz.lesson07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.CompanyEntity;

@Repository
public interface CompanyRepository extends JpaRepository<CompanyEntity, Integer> {  // integer는 키가 되는 값의 타입 하지만, 제네릭에는 int가 들어갈 수 없기에 Integer
	// JpaRepository: Spring Data JPA
	
	// save(엔티티객체) - insert, update(id 채워져있으면)   // extends안했으면 구현해야함.
	// findById() - select
	// delete(엔티티객체)
}
