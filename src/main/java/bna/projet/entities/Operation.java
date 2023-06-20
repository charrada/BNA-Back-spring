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
    @Column(name="idOperation")
    private Long  idOperation;


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


    // Many-to-one
    @ManyToOne
    @JoinColumn(name = "credit_id")
    private Credit credit;




    @OneToOne
    @JoinColumn(name = "typePaimentOperation")
    private TypePaiementOperation typePaiementOperation;



    @Column(name="ribV")
    private Long ribV;

    @Column(name="numC")
    private Long numC;






}
