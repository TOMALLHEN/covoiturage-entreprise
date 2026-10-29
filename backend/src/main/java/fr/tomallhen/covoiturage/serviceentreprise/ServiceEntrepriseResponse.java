package fr.tomallhen.covoiturage.serviceentreprise;

public record ServiceEntrepriseResponse(
        Long id,
        String nom
) {

    public static ServiceEntrepriseResponse from(
            ServiceEntreprise serviceEntreprise
    ) {
        return new ServiceEntrepriseResponse(
                serviceEntreprise.getId(),
                serviceEntreprise.getNom()
        );
    }
}