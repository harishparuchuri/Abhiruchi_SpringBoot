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

import com.abhiruchi.model.Users;
import com.abhiruchi.repositories.UsersRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class UsersController {
	
	
	@Autowired
	private UsersRepository repository;
	
	@GetMapping("/users")
	public List<Users>getAllModels()
	{
		return repository.findAll();
	}
    

    
    @PostMapping("/users")
    public Users createUser(@Valid @RequestBody Users user) {
        return repository.save(user);
    }

	@GetMapping("/users/{id}")
		
		//The @PathVariable annotation in spring binds the URI template variables
	    public ResponseEntity<Users> getUserById(@PathVariable(value = "id") Integer UserId)  {
	        Users user = repository.findById(UserId).orElse(null);
	        return ResponseEntity.ok().body(user);
	   }
	
	
	
    @PutMapping("/users/{id}")
    public ResponseEntity<Users> updateUser(@PathVariable(value = "id") Integer UserId,@Valid @RequestBody Users UserDetails)  {
        Users user = repository.findById(UserId).orElse(null);

        user.setEmail(UserDetails.getEmail());
        user.setName(UserDetails.getName());
        user.setMobile(user.getMobile());
        user.setPassword(user.getPassword());
        final Users updateduser = repository.save(user);
        return ResponseEntity.ok(updateduser);
    }
    
    
    

	@DeleteMapping("/users/{id}")
	public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Integer userId){
		Users user = repository.findById(userId).orElse(null);

		repository.delete(user);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}



}
