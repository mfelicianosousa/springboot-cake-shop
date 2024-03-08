package br.com.mfsdevsystem.cakes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mfsdevsystem.cakes.model.Post;

public interface PostRepository extends JpaRepository<Post,Long>{

}
