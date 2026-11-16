package fr.tomallhen.covoiturage.vehicule;

public record VehiculeResponse(
        Long idVehicule,
        String marque,
        String modele,
        Integer placesPassagers,
        Long idProprietaire
) {

    public static VehiculeResponse from(Vehicule vehicule) {
        return new VehiculeResponse(
                vehicule.getIdVehicule(),
                vehicule.getMarque(),
                vehicule.getModele(),
                vehicule.getPlacesPassagers(),
                vehicule.getProprietaire().getIdSalarie()
        );
    }
}