package tn.esprit.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private List<Clinique> cliniques;

    @OneToMany(mappedBy = "medecin")
    private List<RendezVous> rendezVous;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;
}
