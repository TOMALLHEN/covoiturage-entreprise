package fr.tomallhen.covoiturage.auth;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SalarieProfilRequest(

        @NotBlank
        @Size(max = 50)
        String nom,

        @NotBlank
        @Size(max = 50)
        String prenom,

        @NotBlank
        @Size(max = 255)
        String adresseDomicile

) {
}