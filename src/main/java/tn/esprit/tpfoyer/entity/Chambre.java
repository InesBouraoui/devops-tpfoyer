package tn.esprit.tpfoyer.entity;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Chambre {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long idChambre;

    long numeroChambre;


    @Enumerated(EnumType.STRING)
    TypeChambre typeC;


    @ToString.Exclude
    @OneToMany
    Set<Reservation> reservations;
    @ToString.Exclude
    @ManyToOne(cascade = CascadeType.ALL)
    Bloc bloc;

    public Chambre(long idChambre, long numeroChambre) {
        this.idChambre = idChambre;
        this.numeroChambre = numeroChambre;
    }
}
