package net.anas.bankms.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor @Getter @Setter @ToString
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double solde;
    @Temporal(TemporalType.DATE)
    private Date dateCreation;
    @Enumerated(EnumType.STRING)
    private TypeCompte type;

}
