package fr.tomallhen.covoiturage.participation;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ParticipationService {

    public List<ParticipationResponse> listerMesParticipations(
            String emailSalarie
    ) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Liste des réservations du salarié à implémenter"
        );
    }

    public List<ParticipationResponse> listerPourTrajet(
            Long idTrajet,
            String emailSalarie
    ) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Liste des participants au trajet à implémenter"
        );
    }

    public ParticipationResponse reserver(
            ParticipationRequest request,
            String emailSalarie
    ) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Réservation à implémenter"
        );
    }

    public ParticipationResponse annuler(
            Long id,
            String emailSalarie
    ) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Annulation de la participation à implémenter"
        );
    }

    public ParticipationResponse valider(
            Long id,
            String emailSalarie
    ) {
        throw new ResponseStatusException(
                HttpStatus.NOT_IMPLEMENTED,
                "Validation de la participation à implémenter"
        );
    }
}