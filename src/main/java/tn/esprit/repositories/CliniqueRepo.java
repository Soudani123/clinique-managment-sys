package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.entities.Clinique;

public interface CliniqueRepo extends JpaRepository<Clinique, Long> {
}
