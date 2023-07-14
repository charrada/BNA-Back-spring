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
public class AccountPDP implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;


    @Column(name="username")
    private String  username;

    @Lob // use @Lob annotation to store large binary data
    @Column(name = "picByte", columnDefinition = "VARBINARY(10000)") // increase column length and use LONGBLOB type

    private byte[] picByte;





    







}
