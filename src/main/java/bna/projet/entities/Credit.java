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
    @Column(name="montant")
    private Float montant;
    @ManyToOne
    @JoinColumn(name = "debiteur_id")
    private Debiteur debiteur;


}
