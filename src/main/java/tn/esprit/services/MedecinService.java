package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Clinique;
import tn.esprit.entities.Medecin;
import tn.esprit.repositories.CliniqueRepo;
import tn.esprit.repositories.MedRepo;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class MedecinService implements MedService {

    @Autowired
    private MedRepo medRepo;
    @Autowired
    private CliniqueRepo clinRepo;

    @Override
    public Medecin addAndAssignMedToClinic(Medecin medecin, Long cliniqueId) {
        Optional<Clinique> cliniqueOptional = clinRepo.findById(cliniqueId);

        if (cliniqueOptional.isPresent()) {
            Clinique clinique = cliniqueOptional.get();
System.out.println("medecin.getCliniques()---------------" + medecin.getCliniques());
            medecin.getCliniques().add(clinique);
        } else {
            throw new NoSuchElementException("Clinique pas enregisteré");
        }

        return medRepo.save(medecin);
    }

}
