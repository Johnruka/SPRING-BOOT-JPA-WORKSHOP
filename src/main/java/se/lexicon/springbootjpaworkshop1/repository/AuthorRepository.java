package se.lexicon.springbootjpaworkshop1.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import se.lexicon.springbootjpaworkshop1.entity.Author;

import java.util.List;

public interface AuthorRepository extends CrudRepository<Author, Integer> {


    List<Author> findByFirstName(String firstName);


    List<Author> findByLastName(String lastName);


    List<Author> findByFirstNameContainingOrLastNameContaining(String firstName, String lastName);


    @Modifying
    @Query("update Author a set a.firstName = :firstName, a.lastName = :lastName where a.authorId = :id")
    void updateAuthorName(int id, String firstName, String lastName);


   // @Modifying
    //@Query("delete from Author a where a.authorId = : authorId")
    //void deleteById(int authorId);
}
