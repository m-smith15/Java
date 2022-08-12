package com.shrimpco.dojosandninjas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shrimpco.dojosandninjas.model.Ninja;
import com.shrimpco.dojosandninjas.repository.NinjaRepository;

@Service
public class NinjaService {
	
	@Autowired
	NinjaRepository ninjaRepository;
	
//	private final NinjaRepository ninjaRepository;
//	
//	public NinjaService(NinjaRepository ninjaRepository) {
//		this.ninjaRepository = ninjaRepository;
//	}
	
	//todo - create, find all, find 1, delete
	
	public Ninja createNinja(Ninja n) {
		return ninjaRepository.save(n);
	}
	
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}
	
	public Ninja singleNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
	}

}
