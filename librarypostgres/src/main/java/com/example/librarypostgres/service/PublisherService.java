package com.example.librarypostgres.service;

import com.example.librarypostgres.model.*;
import com.example.librarypostgres.repository.*;
import com.example.librarypostgres.repository.PublisherRepository;
import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PublisherService  implements PublisherRepository{
    @Autowired
    private PublisherJpaRepository publisherJpaRepository;
    @Autowired
    private BookJpaRepository bookJpaRepository;
    @Override
    public ArrayList<Publisher> getPublishers(){
        List<Publisher> publisherList = publisherJpaRepository.findAll();
        ArrayList<Publisher> publishers = new ArrayList<>(publisherList);
        return publishers;
    }
    @Override
    public Publisher getPublisherById(int id){
        try{
        Publisher publisher=publisherJpaRepository.findById(id).get();
        return publisher;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public Publisher addPublisher(Publisher publisher) {

        return   publisherJpaRepository.save(publisher);
    }
    @Override
    public Publisher updatePublisher(int id, Publisher publisher) {
        try{
        Publisher orginal=publisherJpaRepository.findById(id).get();
       

        if(publisher.getPublisherName()!=null){
            orginal.setPublisherName(publisher.getPublisherName());
        }
        
        return  publisherJpaRepository.save(orginal);
    } 
    catch(Exception e){
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
    }
    }
    @Override
    public void deletePublisher(int id) {
        try{
        Publisher publisher=publisherJpaRepository.findById(id).get();
        ArrayList<Book> books=bookJpaRepository.findByPublisher(publisher);
             for(Book book:books)
             {
                book.setPublisher(null);
             }
             bookJpaRepository.saveAll(books);
            publisherJpaRepository.deleteById(id);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    
}
