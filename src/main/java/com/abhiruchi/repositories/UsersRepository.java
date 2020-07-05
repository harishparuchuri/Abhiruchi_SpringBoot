package com.abhiruchi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhiruchi.model.Users;

public interface UsersRepository extends JpaRepository<Users,Integer>{

}
