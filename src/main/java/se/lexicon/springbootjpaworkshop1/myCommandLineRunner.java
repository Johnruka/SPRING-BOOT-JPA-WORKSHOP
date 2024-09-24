package se.lexicon.springbootjpaworkshop1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.springbootjpaworkshop1.entity.AppUser;
import se.lexicon.springbootjpaworkshop1.entity.Details;
import se.lexicon.springbootjpaworkshop1.repository.AppUserRepository;
import se.lexicon.springbootjpaworkshop1.repository.detailsRepository;


@Component
public class myCommandLineRunner implements CommandLineRunner {

    private AppUserRepository appUserRepository;

    private detailsRepository detailsRepository;

    @Autowired
    public myCommandLineRunner(AppUserRepository appUserRepository, detailsRepository detailsRepository) {
        this.appUserRepository = appUserRepository;
        this.detailsRepository = detailsRepository;


    }

    @Override
    public void run(String... args) throws Exception {

        Details details1 = new Details("john@test.se", "Lund John");
        AppUser appUser1 = new AppUser();
        detailsRepository.save(details1);
        appUserRepository.save(appUser1);

    }
}

