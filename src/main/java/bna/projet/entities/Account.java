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
public class Account implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idAccount")
    private Long  idAccount;







    @Temporal (TemporalType.DATE)
    @Column(name="dateCreation")
    private Date dateCreation;



    @Column(name="Nom")
    private String Nom;

    @Column(name="prenom")
    private String prenom;





    @Column(name="typeAccount")
    private String typeAccount;



    @Column(name="username")
    private String username;


    @Column(name="email")
    private String email;



    @Column(name="password")
    private String password;





}
