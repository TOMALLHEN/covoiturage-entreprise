package fr.tomallhen.covoiturage.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record SalarieRequest( 
    @NotBlank(message = "Le nom du salarié est obligatoire.")
    @Size(max = 50, message = "Le nom du salarié ne doit pas dépasser 50 caractères.")
    String nom,

    @NotBlank(message = "Le prénom du salarié est obligatoire.")
    @Size(max = 50, message = "Le prénom du salarié ne doit pas dépasser 50 caractères.")
    String prenom,

    @NotBlank(message = "L'email du salarié est obligatoire.")
    @Email
    @Size(max = 255)
    String email,

    @NotBlank(message = "Le mot de passe du salarié est obligatoire.")
    @Size(min = 8, max = 255)
    String motDePasse,

    @NotBlank(message = "L'adresse du salarié est obligatoire.")
    @Size(max = 255)
    String adresseDomicile,

    @NotNull
    @Positive(message = "L'identifiant du poste doit être positif.")
    Long idPoste,

    @Positive(message = "L'identifiant de l'horaire doit être positif.")
    Long idHoraire

) {
}
