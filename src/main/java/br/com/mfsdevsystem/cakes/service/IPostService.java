package br.com.mfsdevsystem.cakes.service;

import java.util.List;

import br.com.mfsdevsystem.cakes.model.Post;

public interface IPostService {

	List<Post> findAll();
	
	Post findById(Long id);
	
	Post save(Post post);
	
	
}
