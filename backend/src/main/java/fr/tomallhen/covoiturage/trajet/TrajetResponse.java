package fr.tomallhen.covoiturage.trajet;

import java.time.LocalDateTime;

public record TrajetResponse(
        Long idTrajet,
        String adresseDepart,
        Double latitudeDepart,
        Double longitudeDepart,
        String adresseArrivee,
        Double latitudeArrivee,
        Double longitudeArrivee,
        LocalDateTime departPrevuLe,
        LocalDateTime arriveePrevueLe,
        Integer placesProposees,
        String statut,
        LocalDateTime termineLe,
        LocalDateTime creeLe,
        Long idConducteur,
        Long idVehicule
) {

    public static TrajetResponse from(Trajet trajet) {
        return new TrajetResponse(
                trajet.getIdTrajet(),
                trajet.getAdresseDepart(),
                trajet.getLatitudeDepart(),
                trajet.getLongitudeDepart(),
                trajet.getAdresseArrivee(),
                trajet.getLatitudeArrivee(),
                trajet.getLongitudeArrivee(),
                trajet.getDepartPrevuLe(),
                trajet.getArriveePrevueLe(),
                trajet.getPlacesProposees(),
                trajet.getStatut(),
                trajet.getTermineLe(),
                trajet.getCreeLe(),
                trajet.getConducteur().getIdSalarie(),
                trajet.getVehicule().getIdVehicule()
        );
    }
}