package edu.gabrielluan.springwebapp.services;


import org.springframework.stereotype.Service;

import edu.gabrielluan.springwebapp.domain.Author;
import edu.gabrielluan.springwebapp.repositories.AuthorRepository;


@Service
public class AuthorServiceImpl implements AuthorService {

	private final AuthorRepository authorRepository;
	
	
	public AuthorServiceImpl(AuthorRepository authorRepository) {
		this.authorRepository = authorRepository;
	}


	@Override
	public Iterable<Author> findAll() {
		return this.authorRepository.findAll();
	}
	
}
