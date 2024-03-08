package br.com.mfsdevsystem.cakes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mfsdevsystem.cakes.model.Category;
import br.com.mfsdevsystem.cakes.repository.CategoryRepository;

@Service
public class CategoryService {

	private final CategoryRepository categoryRepository;

	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public List<Category> getAllCategory(){
		return categoryRepository.findAll();
	}
	
	public void addCategory(Category category) {
		categoryRepository.save(category);
	}
	
	public void removeCategoryById(int id) {
		categoryRepository.deleteById( id );
	}
	
	public Optional<Category> getCategoryById(int id) {
		return categoryRepository.findById(id);		
	}
	
	
	
}
