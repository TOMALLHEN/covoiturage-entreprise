package fr.tomallhen.covoiturage.trajet;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TrajetService {

    public List<TrajetResponse> lister() {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Recherche des trajets à implémenter"
        );
    }

    public List<TrajetResponse> listerMesTrajets(String emailSalarie) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Liste des trajets du conducteur à implémenter"
        );
    }

    public TrajetResponse consulter(Long id) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Consultation du trajet à implémenter"
        );
    }

    public TrajetResponse creer(
            TrajetRequest request,
            String emailSalarie
    ) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Création du trajet à implémenter"
        );
    }

    public TrajetResponse modifier(
            Long id,
            TrajetRequest request,
            String emailSalarie
    ) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Modification du trajet à implémenter"
        );
    }

    public TrajetResponse annuler(Long id, String emailSalarie) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Annulation du trajet à implémenter"
        );
    }
}