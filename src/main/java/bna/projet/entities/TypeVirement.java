package bna.projet.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Builder // bech nasna3 ay type de constructeur
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TypeVirement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="rib")
    private Long rib;



}

