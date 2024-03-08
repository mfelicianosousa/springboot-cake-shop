package br.com.mfsdevsystem.cakes.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import br.com.mfsdevsystem.cakes.model.Post;
import br.com.mfsdevsystem.cakes.repository.PostRepository;
import jakarta.annotation.PostConstruct;

@Component
public class PostDummyData {

    private final PostRepository postRepository;
	
	public PostDummyData(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	//@PostConstruct
	public void savePosts() {
		List<Post> postList = new ArrayList<>();
		Post post1 = new Post();
		post1.setAuthor("Ana Sapore");
		post1.setPublicationDate(LocalDate.now());
		post1.setTitle("Ovo, curiosidades entre outras histórias");
		post1.setContent("Quem nasceu primeiro, o ovo ou a galinha?");
		post1.setPublished(false); 
		//
		Post post2 = new Post();
		post2.setAuthor("Marcelino Sousa");
		post2.setPublicationDate(LocalDate.now());
		post2.setTitle("Massas de bolo");
		post2.setContent("A massa de bolo é ...");
		post2.setPublished(false); 
		
		postList.add(post1);
		postList.add(post2);
		
		for( Post post: postList) {
			Post postSaved = postRepository.save(post);
			System.out.println(postSaved.getId());
		}
		
		
	}
	
}
