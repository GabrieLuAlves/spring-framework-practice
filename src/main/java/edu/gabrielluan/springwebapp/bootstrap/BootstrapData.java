package edu.gabrielluan.springwebapp.bootstrap;

import edu.gabrielluan.springwebapp.entities.Publisher;
import edu.gabrielluan.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootstrapData implements CommandLineRunner {

    private final PublisherRepository publisherRepository;

    public BootstrapData(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Publisher 01");
        publisher1.setCity("City 01");
        publisher1.setAddress("Address 01");
        publisher1.setState("State 01");
        publisher1.setZip("Zip 01");

        Publisher savedPublusher1 = publisherRepository.save(publisher1);

        Publisher publisher2 = new Publisher();
        publisher2.setPublisherName("Publisher 02");
        publisher2.setCity("City 02");
        publisher2.setAddress("Address 02");
        publisher2.setState("State 02");
        publisher2.setZip("Zip 02");

        Publisher savedPublusher2 = publisherRepository.save(publisher2);

        System.out.println("Number of registered publishers: " + publisherRepository.count());
    }
}
