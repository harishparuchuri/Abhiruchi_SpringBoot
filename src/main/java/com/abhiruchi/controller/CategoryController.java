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

import com.abhiruchi.model.Category;
import com.abhiruchi.repositories.CategoryRepository;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class CategoryController {
	
	@Autowired
	private CategoryRepository repository;

	@GetMapping("/Category")
	public List<Category>getAllProducts(){
		return repository.findAll();
	}

	@PostMapping("/Category")
	public Category createCategory(@Valid @RequestBody Category category) {
		return repository.save(category);
	}

	@GetMapping("/Category/{id}")

	public ResponseEntity<Category> getCategoryById(@PathVariable(value = "id") Integer id) {
		Category category = repository.findById(id).orElse(null);
		return ResponseEntity.ok().body(category);
	}

	@PutMapping("/Category/{id}")

	public ResponseEntity<Category>updateCategory(@PathVariable(value = "id") Integer id,@Valid @RequestBody Category CategoryDetails)  {

		Category category=repository.findById(id).orElse(null);
		category.setCat_Id(category.getCat_Id());
		category.setCat_Name(category.getCat_Name());

		final Category updateCategory=repository.save(category);
		return ResponseEntity.ok(updateCategory);
	}
	
	@DeleteMapping("/Category/{id}")
	public Map<String,Boolean>deleteCategory(@PathVariable(value = "id") Integer id){
		Category category=repository.findById(id).orElse(null);
		repository.delete(category);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}



}
