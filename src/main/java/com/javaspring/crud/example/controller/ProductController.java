package com.javaspring.crud.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javaspring.crud.example.entity.Product;
import com.javaspring.crud.example.service.ProductService;

import java.util.List;

@RestController
public class ProductController
{
	@Autowired
	private ProductService service;
	
	@PostMapping("/addProduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveProduct(product);
	}
	
	@PostMapping("/addProducts")
	public List<Product> addProduct(@RequestBody List<Product> products) {
		return service.saveProduct(products);
	}
	
	@GetMapping("/products")
	public List<Product> findAllProducts(){
		return service.getProducts();
	}
	
	@GetMapping("/product/id={id}")
	public Product findProductById(@PathVariable int id)
	{
		return service.getProductById(id);
	}
	
	@GetMapping("/product/name={name}")
	public Product findProductByName(@PathVariable String name)
	{
		return service.getProductByName(name);
	}
	
	@PutMapping("/update")
	public Product updateProduct(@RequestBody Product product) {
		return service.updateProduct(product);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteProduct(@PathVariable int id)
	{
		return service.deleteProduct(id);
	}
}
//end class