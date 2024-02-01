package com.example.librarypostgres.repository;

import com.example.librarypostgres.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherJpaRepository extends JpaRepository<Publisher,Integer>{
    
}