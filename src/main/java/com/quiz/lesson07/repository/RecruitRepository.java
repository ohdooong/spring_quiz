package com.quiz.lesson07.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.quiz.lesson07.entity.RecruitEntity;



@Repository
public interface RecruitRepository extends JpaRepository<RecruitEntity, Integer>{
	
	//Spring Data JPA
	// findById
	
	
	//JPQL => 엔티티 조회
	
	
	
	// Native query 조회 => DB 직접 조회   // native에선 @Param있어야한다
	@Query(value= "select * from `recruit` "
			+ "where `deadline` > :deadline "
			+ "and `salary` > :salary and `type` = :type "
			+ "order by salary desc", nativeQuery = true)
	public List<RecruitEntity> findByDeadlineAfterAndSalaryGreaterThanEqualAndTypeOrderBySalaryDesc (
			@Param("deadline") String deadline,
			@Param("salary") String salary,
			@Param("type") String type);
	
	
}
