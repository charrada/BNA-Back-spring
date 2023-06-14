package bna.projet.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Debuteur implements Serializable  {



    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id_deb")
    private Long  id_deb;

    @Column(name="nom")
    private String nom;
    @Column(name="prenom")
    private String prenom;
/*
    // One-to-many mapping
    @OneToMany(mappedBy = "debuteur", cascade = CascadeType.ALL)
    private List<Credit> creditList;
*/

}
