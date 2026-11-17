package fr.tomallhen.covoiturage.participation;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ParticipationRequest(

    @NotNull
    @Positive
    Long idTrajet

) {
}
