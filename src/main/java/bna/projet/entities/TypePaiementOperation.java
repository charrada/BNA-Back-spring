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
public class TypePaiementOperation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idType")
    private Long idType;

    @Column(name="nomType")
    private String nomType;

}
