package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.entities.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {
}
