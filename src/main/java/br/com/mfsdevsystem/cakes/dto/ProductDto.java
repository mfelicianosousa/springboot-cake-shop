package br.com.mfsdevsystem.cakes.dto;

import java.io.Serializable;

import br.com.mfsdevsystem.cakes.model.Category;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

public class ProductDto implements Serializable {

		private static final long serialVersionUID = 1L;

		private Long id;
		private String name;
		private String description;
		private String imageName;
		private double price;
		private double weight; 
		private int categoryId;
	
		public ProductDto() {		
		}
		
		public ProductDto(Long id, String name, String description, String imageName, double price, double weight,
				int categoryId) {
			this.id = id;
			this.name = name;
			this.description = description;
			this.imageName = imageName;
			this.price = price;
			this.weight = weight;
			this.categoryId = categoryId;
	    }
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getImageName() {
			return imageName;
		}
		public void setImageName(String imageName) {
			this.imageName = imageName;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		public double getWeight() {
			return weight;
		}
		public void setWeight(double weight) {
			this.weight = weight;
		}
		public int getCategoryId() {
			return categoryId;
		}
		public void setCategoryId(int categoryId) {
			this.categoryId = categoryId;
		}
		
}
