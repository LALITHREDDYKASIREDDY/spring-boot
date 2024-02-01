package com.example.librarypostgres.repository;
import com.example.librarypostgres.model.Book;
import com.example.librarypostgres.model.Publisher;
import com.example.librarypostgres.model.Author;
import java.util.*;

public interface BookRepository {
   
    ArrayList<Book> getBooks();
    Book getBookById(int bookId);
    Book addBook(Book book);
    Book updateBook(int bookId,Book book);
    void deleteBook(int bookId);
    Publisher getBookPublisher(int bookId);
    List<Author> getBookAuthors(int id);
}
