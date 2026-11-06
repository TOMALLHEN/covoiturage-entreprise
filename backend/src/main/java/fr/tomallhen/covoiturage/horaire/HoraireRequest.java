package fr.tomallhen.covoiturage.horaire;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalTime;

public record HoraireRequest(

        @NotBlank
        @Size(max = 80)
        String libelle,

        @NotNull
        LocalTime heureDebut,

        @NotNull
        LocalTime heureFin,

        @NotNull
        @Positive
        Long idService

) {
}