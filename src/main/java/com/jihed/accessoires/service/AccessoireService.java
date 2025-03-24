package com.jihed.accessoires.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.jihed.accessoires.entities.Accessoire;

public interface AccessoireService {

	Accessoire saveAccessoire(Accessoire a);

	Accessoire updateAccessoire(Accessoire p);

	void deleteAccessoire(Accessoire p);

	void deleteAccessoireById(Long id);

	Accessoire getAccessoire(Long id);

	List<Accessoire> getAllAccessoire();
	
	Page<Accessoire> getAllAccessoireParPage(int page,int size);
}
