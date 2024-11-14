package tn.esprit.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.logging.log4j.util.Lazy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMedecin;
    private String nomMedecin;
    private int telephoneMedecin;
    private int prixConsultation;

    @ManyToMany
    @JsonIgnore
    private List<Clinique> cliniques= new ArrayList<>();

    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezVous;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;
}
