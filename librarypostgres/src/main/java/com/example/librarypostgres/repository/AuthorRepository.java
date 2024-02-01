package com.example.librarypostgres.repository;
import com.example.librarypostgres.model.*;

import java.util.*;

public interface AuthorRepository {
   
    ArrayList<Author> getAuthors();
    Author getAuthorById(int authorId);
    Author addAuthor(Author author);
    Author updateAuthor(int authorId,Author author);
    void deleteAuthor(int authorId);
    List<Book> getAuthorBooks(int id);
}
