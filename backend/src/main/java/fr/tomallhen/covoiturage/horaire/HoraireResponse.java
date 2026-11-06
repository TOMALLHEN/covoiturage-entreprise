package fr.tomallhen.covoiturage.horaire;

import java.time.LocalTime;

public record HoraireResponse(
        Long id,
        String libelle,
        LocalTime heureDebut,
        LocalTime heureFin,
        Long idService
) {

    public static HoraireResponse from(Horaire horaire) {
        return new HoraireResponse(
                horaire.getId(),
                horaire.getLibelle(),
                horaire.getHeureDebut(),
                horaire.getHeureFin(),
                horaire.getServiceEntreprise().getId()
        );
    }
}