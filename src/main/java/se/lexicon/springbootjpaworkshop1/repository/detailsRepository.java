package se.lexicon.springbootjpaworkshop1.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.springbootjpaworkshop1.entity.Details;

import java.time.LocalDate;
import java.util.Optional;

public interface detailsRepository extends CrudRepository<Details, Integer> {

    Optional<Details> findByEmail(String email);

    Optional<Details> findByNameContains(String name);

    Optional<Details> findByNameIgnoreCase(String name);

}
