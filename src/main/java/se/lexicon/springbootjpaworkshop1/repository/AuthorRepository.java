package se.lexicon.springbootjpaworkshop1.repository;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import se.lexicon.springbootjpaworkshop1.entity.Author;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Integer> {


    List<Author> findByFirstName(String firstName);


    List<Author> findByLastName(String lastName);


    List<Author> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);


    @Modifying
    @Query("update Author a set a.firstName = :firstName, a.lastName = :lastName where a.authorId = :id")
    void updateAuthorName(int id, String firstName, String lastName);


    //@Modifying
   // @Transactional
   // @Query("DELETE FROM Author a WHERE a.authorId = :authorId")
   // void deleteAuthorById(@Param("authorId") int authorId);
}
