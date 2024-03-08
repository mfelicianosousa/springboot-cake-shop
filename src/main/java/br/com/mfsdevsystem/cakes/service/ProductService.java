package br.com.mfsdevsystem.cakes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mfsdevsystem.cakes.model.Product;
import br.com.mfsdevsystem.cakes.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public List<Product> getAllProduct(){
		return productRepository.findAll();
	}
	
	public void addProduct(Product product) {
		productRepository.save(product);
	}
	
	public void removeProductById(Long id) {
		productRepository.deleteById( id );
	}
	
	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);		
	}
	
	public List<Product> getProductsByCategoryId(int id) {
		return productRepository.findAllByCategoryId(id);		
	}
	
	
	
}
