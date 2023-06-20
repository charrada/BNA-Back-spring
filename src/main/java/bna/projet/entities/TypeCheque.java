package bna.projet.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder // bech nasna3 ay type de constructeur
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TypeCheque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="numC")
    private Long numC;



}

