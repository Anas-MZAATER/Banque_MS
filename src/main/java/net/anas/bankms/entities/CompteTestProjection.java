package net.anas.bankms.entities;

import org.springframework.data.rest.core.config.Projection;

import java.util.Date;

@Projection(name = "test", types = Compte.class)
public interface CompteTestProjection {
    public double getSolde();
    public Date getDateCreation();
}
