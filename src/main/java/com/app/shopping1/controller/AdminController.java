package com.app.shopping1.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.shopping1.dto.CategoryDto;
import com.app.shopping1.dto.ProductDTO;
import com.app.shopping1.entity.Admin;
import com.app.shopping1.entity.Category;
import com.app.shopping1.entity.Product;
import com.app.shopping1.service.AdminService;
import com.app.shopping1.service.CategoryService;
import com.app.shopping1.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/login")
	public Admin loginAdmin(@RequestBody Admin user) throws Exception {
		System.out.println("i am here in login function");
		System.out.println(user);
		String email = user.getEmail();
		String password = user.getPassword();
		Admin userObj = null;
		if(email != null && password != null) {
			
			userObj = adminService.fetchUserByEmailAndPassword(email, password);
			System.out.println("i found the user");
		}
		
		if(userObj == null) {
			throw new Exception("User does not exist");
		}
		System.out.println("before the return line");
		return userObj;
		
	}
	
	
	@PostMapping("/addCategory")
	public Category addNewCategory(@RequestBody Category category) throws Exception {
		System.out.println(category);
		String name = category.getName();
		if(name != null) {
			System.out.println("i am here");
			Category categoryObj = categoryService.FetchCategoryByName(name);
			if(categoryObj != null) {
				throw new Exception("Category already exist1");
			}
		}
		Category categoryTemp = null;
		categoryTemp = categoryService.save(category);
		System.out.println("saving the Category");
		return categoryTemp;
		
	}

	@PostMapping("/addProduct")
	public void addNewProduct(@RequestBody Product product) throws Exception {
		
		Category category = categoryService.FetchCategoryByName(product.getCategory().getName());
		
		if(category == null) {
			throw new Exception("Category doesn't exist");
		}
		
		String name = product.getName();
		if(name != null) {
			Product productObj = productService.FetchProductByName(name);
			if(productObj != null) {
				throw new Exception("Product already exist");
			}
		}
		//Product productTemp = null;
		product.setCategory(category);
		productService.save(product);
		System.out.println("Saving the Product");
		//return productTemp;
		
	}
	
	@GetMapping("/editCategory/{category_name}")
	public CategoryDto getCategory(@PathVariable("category_name") String category_name) throws Exception {

		System.out.println(category_name);
		Category categoryObj = categoryService.FetchCategoryByName(category_name);
		if(categoryObj == null) {
			throw new Exception("Category Not exist");
		}
		System.out.println("i get the object to edit ");
		
		ModelMapper modelMapper = new ModelMapper();
		CategoryDto categoryDTO = modelMapper.map(categoryObj, CategoryDto.class);
		
		return categoryDTO;
		
	}
	
	@PostMapping("/editCategory")
	public void editCategory(@RequestBody Category category){
		
		System.out.println(category.getImage());
		//System.out.println(category);
		System.out.println(category);
		categoryService.edit(category);
	
	}
	
	@GetMapping("/editProduct/{product_name}")
	public ProductDTO getProduct(@PathVariable("product_name") String product_name) throws Exception{

		Product productObj = productService.FetchProductByName(product_name);
		//System.out.println(productObj.getAdmin());
		if(productObj == null) {
			throw new Exception("Product Not exist");
		}
		//System.out.println("i am here before return");
		
		ModelMapper modelMapper = new ModelMapper();
		ProductDTO productDTO = modelMapper.map(productObj, ProductDTO.class);
		
		return productDTO;
	}
	
	@PostMapping("/editProduct")
	public void editProduct(@RequestBody Product product){
		
		productService.edit(product);
	
	}
	
	@PostMapping("/deleteProduct")
	public void deleteProduct(@RequestBody String product_name) throws Exception{
		Product pro = productService.FetchProductByName(product_name);
		if(pro != null) {
			productService.delete(product_name);
		}else {
			throw new Exception("product doesn't found");
		}	
	
	}
	
	@PostMapping("/deleteCategory")
	public void deleteCategory(@RequestBody String category_name) throws Exception{
		Category cat = categoryService.FetchCategoryByName(category_name);
		//System.out.println(cat);
		//System.out.println(cat.getProducts().get(0).getId());
		if(cat != null) {
			System.out.println("here ee");
			categoryService.delete(category_name);
		}else {
			throw new Exception("Category doesn't found");
		}
		
	}
	
	

}
