package com.app.shopping1.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.shopping1.dto.CartItemDTO;
import com.app.shopping1.dto.CategoryDto;
import com.app.shopping1.dto.ProductDTO;
import com.app.shopping1.entity.CartItem;
import com.app.shopping1.entity.Category;
import com.app.shopping1.entity.Order;
import com.app.shopping1.entity.Product;
import com.app.shopping1.entity.User;
import com.app.shopping1.service.CartService;
import com.app.shopping1.service.CategoryService;
import com.app.shopping1.service.OrderService;
import com.app.shopping1.service.ProductService;
import com.app.shopping1.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/shopping")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private CategoryService categoryService;

	@Autowired
	private ProductService productService;

	@Autowired
	private CartService cartService;
	
	@Autowired
	private OrderService orderService;
	
	@PostMapping("/signup")
	public User viewSignUpPage(@RequestBody User user) throws Exception {

		String email = user.getEmail();
		if (email != null) {
			User userObj = userService.fetchUserByEmail(email);
			if (userObj != null) {
				throw new Exception("User already exist");
			}
		}
		User userTemp = null;
		userTemp = userService.saveUser(user);
		System.out.println("saving the User");
		return userTemp;

	}

	@PostMapping("/login")
	public User loginUser(@RequestBody User user) throws Exception {
		System.out.println("i am here in login function");
		String email = user.getEmail();
		String password = user.getPassword();
		User userObj = null;
		if (email != null && password != null) {

			userObj = userService.fetchUserByEmailAndPassword(email, password);
			System.out.println("i found the user");
		}
		if (userObj == null) {
			throw new Exception("User does not exist");
		}
		return userObj;

	}

	@GetMapping("/user/{email}")
	public User getUser(@PathVariable("email") String email) throws Exception {
		User user = userService.fetchUserByEmail(email);
		if (user != null) {
			System.out.println("i am in get user");
			return user;
		} else {
			throw new Exception("This user doesn't exist");
		}
	}

	@PostMapping("/updateUser")
	public void editUser(@RequestBody User editedUser) {
		userService.saveUser(editedUser);
		System.out.println("updated User");
	}

	@PostMapping("/cart/add")
	public void addCartItem(@RequestBody CartItem newCartItem) {
		User user = userService.fetchUserByEmail(newCartItem.getUser().getEmail());
		Product product = productService.FetchProductByName(newCartItem.getProduct().getName());

		CartItem checkCartItem = cartService.FetchCartItemByUserAndProduct((int) user.getId(), (int) product.getId());
		if (checkCartItem != null) {
			checkCartItem.setQuantity(checkCartItem.getQuantity() + newCartItem.getQuantity());
			cartService.edit(checkCartItem);
		} else {
			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setUser(user);
			cartItem.setQuantity(newCartItem.getQuantity());
			cartService.save(cartItem);
			System.out.println("add new cart item");
		}

	}

	@PostMapping("/cart/update")
	public void editCartItem(@RequestBody CartItem newCartItem) {
		cartService.save(newCartItem);
		System.out.println("edited cart item");
	}

	@GetMapping("/cart/delete/{id}")
	public void deleteCart(@PathVariable("id") int id) {
		System.out.println(id);
		CartItem cartItem = cartService.getById(id);
		//System.out.println(cartItem);
		cartService.delete(cartItem);
	}

	@GetMapping("/cart/get/{email}")
	public List<CartItemDTO> showShoppingCart(@PathVariable("email") String email) {
		System.out.println("i am in show shopping cart");
		User user = userService.fetchUserByEmail(email);
		return cartService.listCartItem(user);
	}

	@GetMapping("/cart/counter/{email}")
	public int listCartItems(@PathVariable("email") String email) {
		User user = userService.fetchUserByEmail(email);
		List<CartItemDTO> cartitems = cartService.listCartItem(user);
		int sum = 0;
		for (int i = 0; i < cartService.listCartItem(user).size(); i++) {
			sum += cartitems.get(i).getQuantity();
		}
		return sum;
	}

	@GetMapping("/categories")
	public List<CategoryDto> getCategories() {
		System.out.println("i am in get categories method");
		List<CategoryDto> categories = categoryService.findAll();
//		System.out.println("categories:" + categories);
		return categories;
	}

	@GetMapping("/getCategoryProducts/{name}")
	public List<ProductDTO> getProductsByCategory(@PathVariable("name") String categoryName) {

		Category category = categoryService.FetchCategoryByName(categoryName);
		return productService.FetchProductByCategory(category);
	}

	@GetMapping("/search/{text}")
	public List<ProductDTO> search(@PathVariable("text") String text) {
		System.out.println("i am in search method : " + text);
		System.out.println(productService.searchForProducts(text).size());
		return productService.searchForProducts(text);
	}

	@PostMapping("/confirmOrder")
	public void addOrder(@RequestBody Order order) {
		//System.out.println(order.getCartItem());
		//order.setProducts(order.getProducts());
		orderService.save(order);
		System.out.println("saved Order");
	}
	
	@GetMapping("/randomproduct")
	public List<ProductDTO> getRandomProduct() {
		
		//return productService.getAllProducts();
		int counter = (int)productService.countProducts();
		System.out.println(counter);
		//ModelMapper modelMapper = new ModelMapper();
		if(counter <= 6) {
			return productService.getAllProducts();
		}else {
			return productService.selectRandomProducts();
		}
	}
	
	
}
