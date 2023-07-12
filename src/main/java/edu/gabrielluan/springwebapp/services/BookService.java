package edu.gabrielluan.springwebapp.services;

import edu.gabrielluan.springwebapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

}
