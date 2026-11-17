package fr.tomallhen.covoiturage.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ConnexionRequest(

        @NotBlank
        @Email
        @Size(max = 255)
        String email,

        @NotBlank
        String motDePasse

) {
}