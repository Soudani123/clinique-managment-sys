package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.entities.Clinique;
import tn.esprit.services.CliniqueService;

@RestController
public class CliniqueController {
    @Autowired
    private CliniqueService cliniqueService;

    @PostMapping ("/addClinique")
    public Clinique addClinique(@RequestBody Clinique clinique) {
        return cliniqueService.addClinique(clinique);
    }
}
