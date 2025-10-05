package net.anas.bankms.repositories;

import net.anas.bankms.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface CompteRepo extends JpaRepository<Compte,Long> {
}
