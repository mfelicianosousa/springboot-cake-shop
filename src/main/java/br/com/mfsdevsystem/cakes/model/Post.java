package br.com.mfsdevsystem.cakes.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="blog_post")
public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="post_id")
	private Long id;
	
	@NotBlank
	@Column(length=60)
	private String title ;
	
	@NotBlank
	@Column(length=60)
	private String author;
	
	@NotBlank
	@Lob
	private String content;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern ="dd-MM-yyyy")
	@Column(name = "publication_date")
	private LocalDate publicationDate;
		
	@Column(name = "published", columnDefinition = "BOOLEAN")
	private boolean published;

	
	
	public Post() {
	}
	
	public Post(Long id, @NotBlank String title, @NotBlank String author, @NotBlank String content,
			LocalDate publicationDate, boolean published) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.content = content;
		this.publicationDate = publicationDate;
		this.published = published;
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getPublicationDate() {
		return publicationDate;
	}

	public void setPublicationDate(LocalDate publicationDate) {
		this.publicationDate = publicationDate;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}
	
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}
	
	
		
}
