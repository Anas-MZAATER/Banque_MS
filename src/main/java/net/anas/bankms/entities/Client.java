package net.anas.bankms.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Collection;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Client {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "client")
    private Collection<Compte> comptes;
}
