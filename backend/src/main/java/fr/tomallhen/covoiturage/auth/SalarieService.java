package fr.tomallhen.covoiturage.auth;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SalarieService {

    public List<SalarieResponse> lister() {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Liste des salariés à implémenter"
        );
    }

    public SalarieResponse consulter(Long id) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Consultation du salarié à implémenter"
        );
    }

    public SalarieResponse consulterMonProfil(String emailSalarie) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Consultation du profil connecté à implémenter"
        );
    }

    public SalarieResponse modifierMonProfil(
            SalarieProfilRequest request,
            String emailSalarie
    ) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Modification du profil connecté à implémenter"
        );
    }
}