package fr.tomallhen.covoiturage.auth;

import java.time.LocalDateTime;

public record SalarieResponse(
    Long idSalarie,
    String nom,
    String prenom,
    String email,
    String role,
    String adresseDomicile,
    LocalDateTime creeLe
) {

    public static SalarieResponse from(Salarie salarie) {
        return new SalarieResponse(
                salarie.getIdSalarie(),
                salarie.getNom(),
                salarie.getPrenom(),
                salarie.getEmail(),
                salarie.getRole(),
                salarie.getAdresseDomicile(),
                salarie.getCreeLe()
        );
    }
}
