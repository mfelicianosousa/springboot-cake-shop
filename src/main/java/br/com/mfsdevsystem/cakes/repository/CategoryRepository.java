package br.com.mfsdevsystem.cakes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsystem.cakes.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer >{

}
