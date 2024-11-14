package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.entities.*;
import tn.esprit.repositories.CliniqueRepo;
import tn.esprit.repositories.MedRepo;
import tn.esprit.repositories.PatientRepo;
import tn.esprit.repositories.RDVRepo;

import java.util.*;

@Service
public class RDVService {
    @Autowired
    CliniqueRepo cliniqueRepo;

    @Autowired
    RDVRepo rdvRepo;

    @Autowired
    MedRepo medRepo;

    @Autowired
    PatientRepo patientRepo;

    public RendezVous addRDVAndAssignMedAndPatient( Long idMedecin, Long idPatient, RendezVous rdv) {
        Optional<Medecin> medecinOptional = medRepo.findById(idMedecin);
        Optional<Patient> patientOptional = patientRepo.findById(idPatient);

        if (medecinOptional.isPresent() && patientOptional.isPresent()) {
            Medecin medecin = medecinOptional.get();
            Patient patient = patientOptional.get();

             rdv.setMedecin(medecin);
            rdv.setPatient(patient);

             rdvRepo.save(rdv);
        } else {
            throw new NoSuchElementException("Medecin ou Patient pas enregistreés ");
        }
       return null;
    }


    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(Long idClinique, Specialite specialite) {
         Optional<Clinique> cliniqueOptional = cliniqueRepo.findById(idClinique);
        if (!cliniqueOptional.isPresent()) {
            throw new NoSuchElementException("Clinique not found with the provided ID.");
        }

        Clinique clinique = cliniqueOptional.get();

      List<Medecin> medecins = medRepo.findByCliniquesAndSpecialite(clinique, specialite);


        List<RendezVous> rendezVousList = new ArrayList<>();
        for (Medecin medecin : medecins) {
            rendezVousList.addAll(medecin.getRendezVous());
        }

        return rendezVousList;
    }

    public int getNbrRendezVousMedecin(Long idMedecin){
        return rdvRepo.getNbrRendezVousMedecin(idMedecin);
    }


    @Scheduled(fixedRate = 30000)
    public void retrieveRendezVous() {
        Date currentDate = new Date();
        List<RendezVous> rendezVousList = rdvRepo.findByDateRDVAfter(currentDate);
        rendezVousList.forEach(rdv -> {
            System.out.println("Rendez-vous: " + rdv.getDateRDV() + " | Medecin: " + rdv.getMedecin().getNomMedecin() + " | Patient: " + rdv.getPatient().getNomPatient());
        });
    }
}
