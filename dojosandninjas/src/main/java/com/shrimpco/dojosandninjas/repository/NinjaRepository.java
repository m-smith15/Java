package com.shrimpco.dojosandninjas.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.shrimpco.dojosandninjas.model.Ninja;


@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long>{
	
	List<Ninja> findAll();
	Optional<Ninja> findById(Long id);
	void deleteById(Long id);

}
