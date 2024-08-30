package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository= publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher JunkBook=new Publisher("JunkBook","Sydney","NSW","GreenBank","1102");
        Author peanut = new Author("Pea","Nut");
        Book Seduce=new Book("Seduce","114514",JunkBook.getName());

        peanut.getBooks().add(Seduce);
        Seduce.getAuthors().add(peanut);
        JunkBook.getBooks().add(Seduce);

        authorRepository.save(peanut);
        bookRepository.save(Seduce);
        publisherRepository.save(JunkBook);


        Author walnut=new Author("Wal","Nut");
        Book horney=new Book("Horney","114515",JunkBook.getName());
        walnut.getBooks().add(horney);
        horney.getAuthors().add(walnut);
        JunkBook.getBooks().add(horney);

        authorRepository.save(walnut);
        bookRepository.save(horney);
        //this is not sure, the updating of entities may not need to save() again.
        publisherRepository.save(JunkBook);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: "+bookRepository.count());
        System.out.println(publisherRepository.findAll());
  }
}
