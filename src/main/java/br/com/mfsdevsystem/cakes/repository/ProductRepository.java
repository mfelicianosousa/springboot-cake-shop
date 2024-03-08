package br.com.mfsdevsystem.cakes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsystem.cakes.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long >{

	
	List<Product> findAllByCategoryId(int id);

}
