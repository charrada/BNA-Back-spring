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
public class Credit implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idCredit")
    private Long  idCredit;

//debuteuuur! sans relation
    @Column(name="username")
    private String username;

    @Column(name="montant")
    private Float montant;





/*

    @ManyToOne
    @JoinColumn(name = "debuteur_id")
    private Debuteur debuteur;
*/

}
