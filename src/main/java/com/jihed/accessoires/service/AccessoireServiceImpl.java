package com.jihed.accessoires.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.jihed.accessoires.entities.Accessoire;
import com.jihed.accessoires.repos.AccessoireRepository;

@Service
public class AccessoireServiceImpl implements AccessoireService{

	@Autowired
	AccessoireRepository accessoireRepository;
	@Override
	public Accessoire saveAccessoire(Accessoire a) {
		return accessoireRepository.save(a);
	}

	@Override
	public Accessoire updateAccessoire(Accessoire a) {
		return accessoireRepository.save(a);
	}

	@Override
	public void deleteAccessoire(Accessoire a) {
		accessoireRepository.delete(a);
	}

	@Override
	public void deleteAccessoireById(Long id) {
		accessoireRepository.deleteById(id);
	}

	@Override
	public Accessoire getAccessoire(Long id) {
		return accessoireRepository.findById(id).get();
	}

	@Override
	public List<Accessoire> getAllAccessoire() {
		return accessoireRepository.findAll();
	}

	@Override
	public Page<Accessoire> getAllAccessoireParPage(int page, int size) {
		return accessoireRepository.findAll(PageRequest.of(page, size));  
	}

}
