package se.lexicon.springbootjpaworkshop1.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.springbootjpaworkshop1.entity.Details;

public interface detailsRepository extends CrudRepository<Details, Integer> {
}
