package fr.tomallhen.covoiturage.participation;

import java.time.LocalDateTime;

public record ParticipationResponse(
        Long idParticipation,
        Long idSalarie,
        Long idTrajet,
        String statut,
        LocalDateTime reserveLe,
        LocalDateTime valideLe
) {

    public static ParticipationResponse from(Participation participation) {
        return new ParticipationResponse(
                participation.getIdParticipation(),
                participation.getSalarie().getIdSalarie(),
                participation.getTrajet().getIdTrajet(),
                participation.getStatut(),
                participation.getReserveLe(),
                participation.getValideLe()
        );
    }
}