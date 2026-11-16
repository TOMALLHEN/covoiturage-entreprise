package fr.tomallhen.covoiturage.vehicule;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record VehiculeRequest(

        @NotBlank
        @Size(max = 255)
        String marque,

        @NotBlank
        @Size(max = 255)
        String modele,

        @NotNull
        @Positive
        Integer placesPassagers

) {
}