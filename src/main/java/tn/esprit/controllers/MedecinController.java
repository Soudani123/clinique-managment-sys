package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.entities.Medecin;
import tn.esprit.services.MedecinService;

@RestController
public class MedecinController {

    @Autowired
    private MedecinService medecinService ;

@PostMapping("/addMedecinAndAssignToClinique/{cliniqueId}")
    public Medecin addMedecinAndAssignToClinique (@RequestBody Medecin medecin,@PathVariable Long cliniqueId){
        return medecinService.addAndAssignMedToClinic(medecin,cliniqueId);
    }

}
