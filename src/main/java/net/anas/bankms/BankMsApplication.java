package net.anas.bankms;

import net.anas.bankms.entities.Compte;
import net.anas.bankms.entities.TypeCompte;
import net.anas.bankms.repositories.CompteRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.Date;

@SpringBootApplication
public class BankMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankMsApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepo compteRepo, RepositoryRestConfiguration restConfiguration) {
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class); // Exposer moi id pour chaque compte
            compteRepo.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE));
            compteRepo.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.COURANT));
            compteRepo.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE));

            compteRepo.findAll().forEach(c -> {
                System.out.println(c.toString());
            });
        };
    }

}
