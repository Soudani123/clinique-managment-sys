package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.entities.Patient;
import tn.esprit.entities.RendezVous;
import tn.esprit.services.PatientService;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;


    @PostMapping("/addPatient")
    public Patient addPatient(@RequestBody Patient patient){
        return patientService.addPatient(patient);

    }
}
