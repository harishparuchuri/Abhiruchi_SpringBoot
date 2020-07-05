package com.abhiruchi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhiruchi.model.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
