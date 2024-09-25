package se.lexicon.springbootjpaworkshop1.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.springbootjpaworkshop1.entity.BookLoan;

public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {
}
