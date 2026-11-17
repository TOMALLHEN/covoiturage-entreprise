package fr.tomallhen.covoiturage.vehicule;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VehiculeService {

    public List<VehiculeResponse> lister(String emailSalarie) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Liste des véhicules à implémenter"
        );
    }

    public VehiculeResponse consulter(Long id, String emailSalarie) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Consultation du véhicule à implémenter"
        );
    }

    public VehiculeResponse creer(
            VehiculeRequest request,
            String emailSalarie
    ) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Création du véhicule à implémenter"
        );
    }

    public VehiculeResponse modifier(
            Long id,
            VehiculeRequest request,
            String emailSalarie
    ) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Modification du véhicule à implémenter"
        );
    }

    public void supprimer(Long id, String emailSalarie) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Suppression du véhicule à implémenter"
        );
    }
}