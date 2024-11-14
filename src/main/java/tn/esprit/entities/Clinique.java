package tn.esprit.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Clinique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClinique;
    private String nomClinique;
    private String adresseClinique;
    private String telephoneClinique;

    @ManyToMany(mappedBy = "cliniques")
    private List<Medecin> medecins;


}


