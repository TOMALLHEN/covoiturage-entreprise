package fr.tomallhen.covoiturage.serviceentreprise;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ServiceEntrepriseRequest(
        @NotBlank(message = "Le nom du service est obligatoire.")
        @Size(max = 80, message = "Le nom ne doit pas dépasser 80 caractères.")
        String nom
) {
}