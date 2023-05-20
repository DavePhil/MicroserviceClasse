package com.foft.microserviceclasse.modele;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

@Data
@Entity
@DynamicUpdate
public class Classe {
    @Id
    @GeneratedValue
    private Integer id;
    @ManyToOne
    private Niveau niveau;
    @ManyToOne
    private Specialite specialite;

}
