package net.anas.bankms.web;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import net.anas.bankms.entities.Compte;
import net.anas.bankms.repositories.CompteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Path("/banque")
public class CompteRestJaxRSAPI {

    @Autowired
    private CompteRepo compteRepo;
    @Path("/comptes")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public List<Compte> compteList() {
        return compteRepo.findAll();
    }
    @Path("/comptes/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Compte getCompte(@PathParam(value = "id") Long id) {
        return compteRepo.findById(id).get();
    }
    @Path("/comptes")
    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Compte saveCompte(Compte compte) {
        return compteRepo.save(compte);
    }
    @Path("/comptes/{id}")
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    public Compte updateCompte(Compte compte,@PathParam(value = "id") Long id) {
        compte.setId(id);
        return compteRepo.save(compte);
    }
    @Path("/comptes/{id}")
    @DELETE
    @Produces({MediaType.APPLICATION_JSON})
    public void deleteCompte(@PathParam(value = "id") Long id) {
        compteRepo.deleteById(id);
    }
}
