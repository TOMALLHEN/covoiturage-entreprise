package fr.tomallhen.covoiturage.auth;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record SalarieAffectationRequest(

        @NotNull
        @Positive
        Long idPoste,

        @Positive
        Long idHoraire

) {
}