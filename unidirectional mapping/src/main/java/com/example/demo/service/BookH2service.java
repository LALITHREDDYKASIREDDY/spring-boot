package com.example.demo.service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookJpaRepository;
import com.example.demo.repository.PublisherJpaRepository;
import com.example.demo.repository.BookRepository;
import com.example.demo.model.Publisher;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class BookH2service  implements BookRepository{
    @Autowired
    private BookJpaRepository bookJpaRepository;
    
    @Autowired
    private PublisherJpaRepository publisherJpaRepository;
    @Override
    public ArrayList<Book> getBooks(){
        List<Book> bookList = bookJpaRepository.findAll();
        ArrayList<Book> books = new ArrayList<>(bookList);
        return books;
    }
    @Override
    public Book getBookById(int id){
        try{
        Book book=bookJpaRepository.findById(id).get();
        return book;
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    @Override
    public Book addBook(Book book) {
        Publisher publisher1 = book.getPublisher();
        int publisherId = publisher1.getId();
        try {
            
            Publisher publisher = publisherJpaRepository.findById(publisherId).get();
            book.setPublisher(publisher);
            bookJpaRepository.save(book);
            return book;
        } catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong publisherId");
        }
    }
    @Override
    public Book updateBook(int bookId, Book book) {
        Book orginal=bookJpaRepository.findById(bookId).get();
        if(orginal == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        if(book.getName()!=null){
          orginal.setName(book.getName());
        } 
        if(book.getImageUrl()!=null){
            orginal.setImageUrl(book.getImageUrl());
        }
        if(book.getPublisher()!=null){
            Publisher publisher1 = book.getPublisher();
            int id=publisher1.getId();
            try {
            
                Publisher publisher = publisherJpaRepository.findById(id).get();
                book.setPublisher(publisher);
           
            } catch(Exception e){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Wrong publisherId");
            }
        }
        bookJpaRepository.save(orginal);
        return orginal;
   
    }
    @Override
    public void deleteBook(int bookId) {
        Book orginal=bookJpaRepository.findById(bookId).get();
        if(orginal == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        bookJpaRepository.deleteById(bookId);
    }
    @Override
    public Publisher getBookPublisher(int id){
        try {
            Book book = bookJpaRepository.findById(id).get();
            System.out.println("somfj");
            return book.getPublisher();
          } catch(Exception e){
              throw new ResponseStatusException(HttpStatus.NOT_FOUND);
          }
    }
}
