package com.shrimpco.dojosandninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrimpco.dojosandninjas.model.Dojo;
import com.shrimpco.dojosandninjas.repository.DojoRepository;

@Service
public class DojoService {
	
	@Autowired
	DojoRepository dojoRepository;
	
//	public DojoService(DojoRepository dojoRepository) {
//		this.dojoRepository = dojoRepository;
//	}
	
	//todo create, find all, find 1, delete
	
	public Dojo createDojo(Dojo d) {
		return dojoRepository.save(d);
	}
	
	public List<Dojo> allDojos(){
		return dojoRepository.findAll();
	}
	
	public Dojo singleDojo( Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
			if(optionalDojo.isPresent()) {
				return optionalDojo.get();
			} else {
				return null;
			}
	}
	
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
	}

}
