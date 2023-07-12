package edu.gabrielluan.springwebapp.repositories;

import edu.gabrielluan.springwebapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {

}
