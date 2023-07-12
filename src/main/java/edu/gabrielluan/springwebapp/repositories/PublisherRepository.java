package edu.gabrielluan.springwebapp.repositories;

import edu.gabrielluan.springwebapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {

}
