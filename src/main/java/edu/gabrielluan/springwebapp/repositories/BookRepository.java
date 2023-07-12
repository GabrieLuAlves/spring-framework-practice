package edu.gabrielluan.springwebapp.repositories;

import edu.gabrielluan.springwebapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
