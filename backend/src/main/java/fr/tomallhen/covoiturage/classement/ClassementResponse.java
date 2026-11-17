package fr.tomallhen.covoiturage.classement;

public record ClassementResponse(
        Long idSalarie,
        String nom,
        String prenom,
        long nombreCovoiturages
) {
}