package net.anas.bankms.web;


import net.anas.bankms.entities.Compte;
import net.anas.bankms.repositories.CompteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RequestMapping("/banque")
public class CompteRestControllerAPI {

    @Autowired
    private CompteRepo compteRepo;

    @GetMapping(path = "/comptes",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    public List<Compte> compteList() {
        return compteRepo.findAll();
    }

    @GetMapping(path = "/comptes/{id}")
    public Compte getCompte(@PathVariable Long id) {
        return compteRepo.findById(id).get();
    }

    @PostMapping(path = "/comptes")
    public Compte saveCompte(@RequestBody Compte compte) {
        return compteRepo.save(compte);
    }

    @PutMapping(path = "/comptes/id")
    public Compte updateCompte(@RequestBody Compte compte,@PathVariable Long id) {
        compte.setId(id);
        return compteRepo.save(compte);
    }

    @DeleteMapping(path = "/comptes/{id}")
    public void deleteCompte(@PathVariable Long id) {
        compteRepo.deleteById(id);
    }
}
