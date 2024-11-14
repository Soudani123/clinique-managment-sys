package tn.esprit.services;

import tn.esprit.entities.Medecin;

public interface MedService {

    public Medecin addAndAssignMedToClinic (Medecin medecin, Long cliniqueId);

}
