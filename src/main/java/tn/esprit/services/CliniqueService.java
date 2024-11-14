package tn.esprit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.Clinique;
import tn.esprit.repositories.CliniqueRepo;

@Service
public class CliniqueService {
    @Autowired
    private CliniqueRepo cliniqueRepo;


    public Clinique addClinique (Clinique clinique){
         return cliniqueRepo.save(clinique);
    }


}
