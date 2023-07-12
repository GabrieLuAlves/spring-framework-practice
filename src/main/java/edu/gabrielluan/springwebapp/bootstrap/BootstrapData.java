package edu.gabrielluan.springwebapp.bootstrap;

import edu.gabrielluan.springwebapp.domain.Author;
import edu.gabrielluan.springwebapp.domain.Book;
import edu.gabrielluan.springwebapp.domain.Publisher;
import edu.gabrielluan.springwebapp.repositories.AuthorRepository;
import edu.gabrielluan.springwebapp.repositories.BookRepository;
import edu.gabrielluan.springwebapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootstrapData implements CommandLineRunner {

    final private AuthorRepository authorRepository;
    final private BookRepository bookRepository;
    final private PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author robertMartin = new Author();
        robertMartin.setFirstName("Robert");
        robertMartin.setLastName("Martin");

        Book cleanCode = new Book();
        cleanCode.setTitle("Clean Code");
        cleanCode.setIsbn("978-8576082675");

        /*
        *
        * Deam Wampler is a co-author, but for simplification purposes
        * let's leave it as a one-to-one relation.
        *
        *  */
        Book cleanArchitecture = new Book();
        cleanArchitecture.setTitle("Clean Architecture");
        cleanArchitecture.setIsbn("978-0132350884");

        Author ericEvans = new Author();
        ericEvans.setFirstName("Eric");
        ericEvans.setLastName("Evans");

        Book domainDrivenDesign = new Book();
        domainDrivenDesign.setTitle("Domain Driven Design");
        domainDrivenDesign.setIsbn("978-0321125217");

        Publisher addisonWesley = new Publisher();
        addisonWesley.setPublisherName("Addison-Wesley Professional");
        addisonWesley.setCity("City 01");
        addisonWesley.setAddress("Address 01");
        addisonWesley.setState("State 01");
        addisonWesley.setZip("Zip 01");

        Publisher pearson = new Publisher();
        pearson.setPublisherName("Pearson");
        pearson.setCity("City 02");
        pearson.setAddress("Address 02");
        pearson.setState("State 02");
        pearson.setZip("Zip 02");

        Author savedRobertMartin = authorRepository.save(robertMartin);
        Author savedEricEvans = authorRepository.save(ericEvans);
        Book savedCleanCode = bookRepository.save(cleanCode);
        Book savedCleanArchitecture = bookRepository.save(cleanArchitecture);
        Book savedDomainDrivenDesign = bookRepository.save(domainDrivenDesign);
        Publisher savedAddisonWesley = publisherRepository.save(addisonWesley);
        Publisher savedPearson = publisherRepository.save(pearson);

        savedCleanCode.setPublisher(savedPearson);
        savedCleanArchitecture.setPublisher(savedPearson);
        savedDomainDrivenDesign.setPublisher(savedAddisonWesley);

        savedCleanArchitecture.getAuthors().add(savedRobertMartin);
        savedCleanCode.getAuthors().add(savedRobertMartin);
        savedDomainDrivenDesign.getAuthors().add(savedEricEvans);

        savedRobertMartin.getBooks().add(savedCleanCode);
        savedRobertMartin.getBooks().add(savedCleanArchitecture);
        savedEricEvans.getBooks().add(savedDomainDrivenDesign);

        bookRepository.save(savedCleanCode);
        bookRepository.save(savedCleanArchitecture);
        bookRepository.save(savedDomainDrivenDesign);

        System.out.println("Number of registered books: " + bookRepository.count());
        System.out.println("Number of registered authors: " + authorRepository.count());
        System.out.println("Number of registered publishers: " + publisherRepository.count());
    }
}
