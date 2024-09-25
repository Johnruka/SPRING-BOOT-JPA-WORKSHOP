package se.lexicon.springbootjpaworkshop1.repository;


import org.springframework.data.repository.CrudRepository;

import se.lexicon.springbootjpaworkshop1.entity.BookLoan;

import java.time.LocalDate;
import java.util.List;


public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {


    List<BookLoan> findByBorrower_Id(int borrowerId);


    List<BookLoan> findByReturnedFalse();


    List<BookLoan> findByLoanDateBetween(LocalDate startDate, LocalDate endDate);


}


