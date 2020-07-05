package com.abhiruchi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhiruchi.model.Products;

public interface ProductsRepository extends JpaRepository<Products,Integer> {

}
