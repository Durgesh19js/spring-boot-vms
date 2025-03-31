package com.vi.service;

import java.util.List;

import com.vi.entity.Visitor;

public interface VisitorService {
	Visitor addVisitor(Visitor visitor);
	Visitor updateVisitor(Visitor visitor);
	void deleteVisitorByID(Integer id);
	Visitor getVisitorByID(Integer id );
	List<Visitor> getAllVisitors();
	Visitor getVisitorByEmail(String email);
	

}
