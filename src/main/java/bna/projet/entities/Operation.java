package bna.projet.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Operation implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idFrais")
    private Long  idFrais;


    @Column(name="montant")
    private Float montant;

//id agent
    @Column(name="idAgent")
    private Long idAgent;


    @Column(name="description")
    private String description;


    @Temporal (TemporalType.DATE)
    @Column(name="dateF")
    private Date dateF;


    @Enumerated(EnumType.ORDINAL)
    TypeOperation typeOperation;



    @Column(name = "isValid", columnDefinition = "boolean default false")
    private Boolean isValid=false;


    // Many-to-one
    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;

}
