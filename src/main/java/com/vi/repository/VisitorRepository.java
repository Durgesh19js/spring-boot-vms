package com.vi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.vi.entity.Visitor;
@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Integer>{

	Visitor findByEmail(String email);
}