package com.example.demodb2.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo2 extends JpaRepository<com.example.demo.Entity.User, Integer> {

}