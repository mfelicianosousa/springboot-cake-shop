package br.com.mfsdevsystem.cakes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.mfsdevsystem.cakes.model.Post;
import br.com.mfsdevsystem.cakes.repository.PostRepository;

@Service
public class PostService implements IPostService {

	private final PostRepository postRepository;
	
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public List<Post> findAll() {
		
		return postRepository.findAll();
	}

	@Override
	public Post findById(Long id) {
		
		return postRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		
		return postRepository.save(post);
	}

}
