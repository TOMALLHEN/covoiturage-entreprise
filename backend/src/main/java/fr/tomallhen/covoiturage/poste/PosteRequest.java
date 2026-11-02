package fr.tomallhen.covoiturage.poste;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record PosteRequest(

        @NotBlank(message = "Le nom du poste est obligatoire.")
        @Size(max = 80, message = "Le nom ne doit pas dépasser 80 caractères.")
        String nom,

        @NotNull(message = "Le service est obligatoire.")
        @Positive(message = "L'identifiant du service doit être positif.")
        Long idService

) {
}