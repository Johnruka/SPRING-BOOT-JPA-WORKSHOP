package se.lexicon.springbootjpaworkshop1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.springbootjpaworkshop1.entity.AppUser;
import se.lexicon.springbootjpaworkshop1.repository.AppUserRepository;

@Component
public class MyCommandLineRunner implements CommandLineRunner {


@Autowired
   AppUserRepository appUserRepository;


    @Override
    public void run(String... args) throws Exception {

    }
}
