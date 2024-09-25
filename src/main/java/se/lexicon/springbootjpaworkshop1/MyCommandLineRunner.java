package se.lexicon.springbootjpaworkshop1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import se.lexicon.springbootjpaworkshop1.repository.AppUserRepository;
import se.lexicon.springbootjpaworkshop1.repository.detailsRepository;

;

public class MyCommandLineRunner {

    @Component
    public class myCommandLineRunner implements CommandLineRunner {

        @Autowired
        AppUserRepository appUserRepository;

        @Autowired
        detailsRepository detailsRepository;

        @Override
        public void run(String... args) throws Exception {

        }
    }
}

