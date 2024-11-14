package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.RendezVous;
import tn.esprit.entities.Specialite;
import tn.esprit.services.RDVService;

import java.util.List;

@RestController
public class RDVController {


    @Autowired
    RDVService rdvService;

    @PostMapping("/addRDVAndAssignMedAndPatient/{medecinId}/{patientId}")
    public RendezVous addRDVAndAssignMedAndPatient(@PathVariable Long medecinId,
                                                   @PathVariable Long patientId,
                                                   @RequestBody RendezVous rendezVous) {
         return rdvService.addRDVAndAssignMedAndPatient(medecinId, patientId, rendezVous);
    }

    @GetMapping("/getRendezVousByCliniqueAndSpecialite/{idClinique}")
    public List<RendezVous> getRendezVousByCliniqueAndSpecialite(@PathVariable Long idClinique, @RequestBody Specialite specialite){
    return rdvService.getRendezVousByCliniqueAndSpecialite(idClinique,specialite);
    }
    @GetMapping("/getNbrRendezVousMedecin/{idMedecin}")
    public int getNbrRendezVousMedecin(@PathVariable Long idMedecin){
        return rdvService.getNbrRendezVousMedecin(idMedecin);
    }
}
