package se.lexicon.springbootjpaworkshop1.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.springbootjpaworkshop1.entity.AppUser;



public interface AppUserRepository extends CrudRepository<AppUser, String> {
}



