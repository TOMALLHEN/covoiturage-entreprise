package fr.tomallhen.covoiturage.poste;

public record PosteResponse(Long id, String nom, Long idService) {

    public static PosteResponse from(Poste poste) {
        return new PosteResponse(
                poste.getId(),
                poste.getNom(),
                poste.getServiceEntreprise().getId()
        );
    }
}