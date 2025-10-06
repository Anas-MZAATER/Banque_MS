package net.anas.bankms;

import net.anas.bankms.entities.Client;
import net.anas.bankms.entities.Compte;
import net.anas.bankms.entities.TypeCompte;
import net.anas.bankms.repositories.ClientRepo;
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
    CommandLineRunner start(CompteRepo compteRepo,
                            RepositoryRestConfiguration restConfiguration,
                            ClientRepo clientRepo) {
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class); // Exposer moi id pour chaque compte

            Client c1 = clientRepo.save(new Client(null,"hassan",null));
            Client c2 = clientRepo.save(new Client(null,"anas",null));

            compteRepo.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE,c1));
            compteRepo.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.COURANT,c2));
            compteRepo.save(new Compte(null,Math.random()*9000,new Date(), TypeCompte.EPARGNE,c2));

            compteRepo.findAll().forEach(c -> {
                System.out.println(c.getType());
            });
        };
    }

}
