package bna.projet.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AuxiliaireOperation implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idAux")
    private Long  idAux;





    @Column(name="nomAux")
    private String   nomAux;




    @Column(name="prenAux")
    private String   prenAux;



    @Column(name="typeAux")
    private String   typeAux;


}
