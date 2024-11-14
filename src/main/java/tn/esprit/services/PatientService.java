package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Patient;
import tn.esprit.repositories.PatientRepo;

@Service
public class PatientService {

    @Autowired
    public PatientRepo patientRepo;

    public Patient addPatient(Patient patient){
        return patientRepo.save(patient);
    }
}
