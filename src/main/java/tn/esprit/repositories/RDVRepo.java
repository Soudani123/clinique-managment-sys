package tn.esprit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.entities.RendezVous;

import java.util.Date;
import java.util.List;

public interface RDVRepo extends JpaRepository<RendezVous,Long> {

    @Query("SELECT COUNT(r) FROM RendezVous r WHERE r.medecin.idMedecin = :idMedecin")
    int getNbrRendezVousMedecin(@Param("idMedecin") Long idMedecin);

    List<RendezVous> findByDateRDVAfter(Date currentDate);
}
