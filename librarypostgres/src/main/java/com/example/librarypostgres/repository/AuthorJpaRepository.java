package com.example.librarypostgres.repository;

import com.example.librarypostgres.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorJpaRepository extends JpaRepository<Author,Integer>{
    
}