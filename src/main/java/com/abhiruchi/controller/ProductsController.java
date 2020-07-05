package com.abhiruchi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhiruchi.model.Products;
import com.abhiruchi.repositories.ProductsRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin

public class ProductsController {
	
	@Autowired
	private ProductsRepository repository;
	
	
	@GetMapping("/Products")
	public List<Products>getAllProducts(){
		return repository.findAll();
	}
	
	@PostMapping("/Products")
	public Products createProduct(@Valid @RequestBody Products products) {
		
		 return repository.save(products);
	}
	
	
	@GetMapping("/Products/{id}")
	
	public ResponseEntity<Products> getProductById(@PathVariable(value = "id") Integer Fid)  {
		Products products = repository.findById(Fid).orElse(null);
        return ResponseEntity.ok().body(products);
   }
	
	
	
	
	@PutMapping("/Products/{id}")
	
	public ResponseEntity<Products>updateProduct(@PathVariable(value = "id") Integer id,@Valid @RequestBody Products productDetails)  {
		
		Products product=repository.findById(id).orElse(null);
		product.setProduct_Name(product.getProduct_Name());
		
		
		final Products updateProduct=repository.save(product);
		return ResponseEntity.ok(updateProduct);
	}
	
	@DeleteMapping("/Products/{id}")
	public Map<String,Boolean>deleteProduct(@PathVariable(value = "id") Integer id){
		Products product=repository.findById(id).orElse(null);
		repository.delete(product);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
	




	
	
	

}
