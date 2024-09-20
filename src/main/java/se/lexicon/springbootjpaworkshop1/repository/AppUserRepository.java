package se.lexicon.springbootjpaworkshop1.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.springbootjpaworkshop1.entity.AppUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface AppUserRepository extends CrudRepository<AppUser, String> {

    Optional<AppUser> findByUsername(String username);

    Optional<List<AppUser>> findBetweenTwoDates(LocalDate startDate, LocalDate endDate);

    Optional<AppUser> findByDetailsId(int detailsId);

    Optional<AppUser> findByEmailIgonreCase(String email);

}



