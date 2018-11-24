package com.example.demo.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entities.Produit;

public interface IProduitRepository extends MongoRepository<Produit, String> {
	
	@Query(value="{'designation' : { $regex: ?0, $options: 'i'} }")
	public List<Produit> produitParMC(String designation);
	
	
	@Query(value="{'designation' : { $regex: ?0, $options: 'i'} }")
	public Page<Produit> produitParMC(String designation,Pageable p);
	
	
	
	public List<Produit> findByDescription(String des);
	public Page<Produit> findByDescription(String des, Pageable p);
	

}
