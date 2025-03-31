package com.vi.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vi.entity.Visitor;
import com.vi.repository.VisitorRepository;
import com.vi.service.VisitorService;

@Service
public class VisitorServiceImpl implements VisitorService {
	@Autowired
	VisitorRepository visitorRepository;

	@Override
	public Visitor addVisitor(Visitor visitor) {

		return visitorRepository.save(visitor);
	}

	@Override
	public Visitor updateVisitor(Visitor visitor) {
		Optional<Visitor> v = visitorRepository.findById(visitor.getId());
		if (v.isEmpty()) {
			return null;

		} else {
			return visitorRepository.save(visitor);

		}

	}

	@Override
	public void deleteVisitorByID(Integer id) {
		visitorRepository.deleteById(id);
	}

	@Override
	public Visitor getVisitorByID(Integer id) {

		Optional<Visitor> v = visitorRepository.findById(id);
		if (v.isEmpty()) {
			return null;
		} else {
			return v.get();
		}
	}

	@Override
	public List<Visitor> getAllVisitors() {
		return visitorRepository.findAll();
	}

	@Override
	public Visitor getVisitorByEmail(String email) {
		Optional<Visitor> v = Optional.ofNullable(visitorRepository.findByEmail(email));
		if(v.isEmpty()) {
			return null;
		}
		else {
			return v.get();
		}
	}

}
