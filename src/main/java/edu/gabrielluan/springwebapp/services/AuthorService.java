package edu.gabrielluan.springwebapp.services;

import edu.gabrielluan.springwebapp.domain.Author;

public interface AuthorService {
	
	Iterable<Author> findAll();
	
}
