package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.entities.Clinique;
import tn.esprit.entities.Medecin;
import tn.esprit.entities.Specialite;

import java.util.List;

public interface MedRepo extends JpaRepository<Medecin, Long> {
    List<Medecin> findByCliniquesAndSpecialite(Clinique clinique, Specialite specialite);



}
