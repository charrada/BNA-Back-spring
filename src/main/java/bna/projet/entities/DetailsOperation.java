package bna.projet.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class DetailsOperation implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idDetails")
    private Long  idDetails;


    @Column(name="typeDetails") //ml barra !!
    private String typeDetails;



    @Column(name="numPieceEnregistrement")
    private Long  numPieceEnregistrement;


    @Column(name="typePieceEnregistrement")
    private String   typePieceEnregistrement;




    @Column(name="typeTimbrage")
    private String   typeTimbrage;




    @Column(name="numAffaireAuxiliaire")
    private Long  numAffaireAuxiliaire;





}
