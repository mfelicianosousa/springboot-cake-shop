package br.com.mfsdevsystem.cakes.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import br.com.mfsdevsystem.cakes.dto.ProductDto;
import br.com.mfsdevsystem.cakes.model.Category;
import br.com.mfsdevsystem.cakes.model.Product;
import br.com.mfsdevsystem.cakes.service.CategoryService;
import br.com.mfsdevsystem.cakes.service.ProductService;



@Controller
public class AdminController {
	private static String uploadDir = System.getProperty("user.dir").concat("/src/main/resources/static/productImages");
	
	private final CategoryService categoryService;
	private final ProductService productService;
	
	public AdminController(CategoryService categoryService, ProductService productService) {
		this.categoryService = categoryService;
		this.productService = productService;
	}

	@GetMapping("/admin")
	public String adminHome() {
		return "adminHome";
	}
	
	@GetMapping("/admin/categories")
	public String getCategory(Model model) {
		
		model.addAttribute("categories", categoryService.getAllCategory());
		return "categories";
	}
	
	@GetMapping("/admin/categories/add")
	public String getCategoryAdd(Model model) {
		model.addAttribute("category", new Category());
		return "categoriesAdd";
	}
	
	@PostMapping("/admin/categories/add")
	public String postCategoryAdd(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCategory(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
	}
	
	@GetMapping("/admin/categories/update/{id}")
	public String updateCategory(@PathVariable int id, Model model) {
		Optional<Category> category = categoryService.getCategoryById(id);
		if (category.isPresent()) {
			model.addAttribute("category", category.get());
			return "categoriesAdd";
		} else {
			return "404";
		}
	
	}
	
	// product
	@GetMapping("/admin/products")
	public String getProducts(Model model) {
		model.addAttribute("products", productService.getAllProduct());
		return "products";
	}
	
	@GetMapping("/admin/products/add")
	public String getProductAdd(Model model) {
		model.addAttribute("productDto", new ProductDto());
		model.addAttribute("categories", categoryService.getAllCategory());
		return "productsAdd";
	}
	
	@PostMapping("/admin/products/add")
	public String postProductAdd( 
			@ModelAttribute("productDto") ProductDto productDto,
			@RequestParam("productImage") MultipartFile file, 
			@RequestParam("imgName") String imgName) throws IOException {
		Product product = new Product();
		product.setId(productDto.getId());
		product.setName(productDto.getName());
		product.setCategory( categoryService.getCategoryById(productDto.getCategoryId()).get());
		product.setPrice(productDto.getPrice());
		product.setWeight(productDto.getWeight()); 
		product.setDescription(productDto.getDescription());
		
		String imageUUID; 
		if ( !file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		} else {
			imageUUID = imgName;
		}
		product.setImageName(imageUUID);
		
		productService.addProduct( product );
		return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable Long id) {
		productService.removeProductById(id);
		return "redirect:/admin/products";
	}
	
	@GetMapping("/admin/product/update/{id}")
	public String updateProduct(@PathVariable Long id, Model model) {
		Product product = productService.getProductById(id).get();
		ProductDto productDto = new ProductDto();
		
		productDto.setId(product.getId());
		productDto.setName(product.getName());
		productDto.setCategoryId(( product.getCategory().getId()));
		productDto.setPrice(product.getPrice());
		productDto.setWeight(product.getWeight());
		productDto.setDescription(product.getDescription());
		productDto.setImageName(product.getImageName());
		//
		model.addAttribute("categories",categoryService.getAllCategory());
		model.addAttribute("productDto",productDto);
		//
		return "productsAdd";
	
	}
	
	
	
}
