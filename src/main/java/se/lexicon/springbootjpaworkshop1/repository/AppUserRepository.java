package se.lexicon.springbootjpaworkshop1.repository;


import org.springframework.data.repository.CrudRepository;
import se.lexicon.springbootjpaworkshop1.entity.AppUser;


import java.util.Optional;


public interface AppUserRepository extends CrudRepository<AppUser, String> {

    Optional<AppUser> findByUsername(String username);

   // Optional<List<AppUser>> findBetweenTwoDates(LocalDate startDate, LocalDate endDate);

    Optional<AppUser> findById(int detailsId);

    Optional<AppUser> findByUsernameAndPassword(String username, String password);

}



