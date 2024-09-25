package se.lexicon.springbootjpaworkshop1.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.springbootjpaworkshop1.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends CrudRepository<Book, Integer> {

    Optional<Book> findByIsbnIgnoreCase(String isbn);
    List<Book> findByTitleContaining(String title);
}
