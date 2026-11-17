package fr.tomallhen.covoiturage.trajet;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public record TrajetRequest(

        @NotBlank
        @Size(max = 255)
        String adresseDepart,

        @NotNull
        @DecimalMin("-90")
        @DecimalMax("90")
        Double latitudeDepart,

        @NotNull
        @DecimalMin("-180")
        @DecimalMax("180")
        Double longitudeDepart,

        @NotBlank
        @Size(max = 255)
        String adresseArrivee,

        @NotNull
        @DecimalMin("-90")
        @DecimalMax("90")
        Double latitudeArrivee,

        @NotNull
        @DecimalMin("-180")
        @DecimalMax("180")
        Double longitudeArrivee,

        @NotNull
        LocalDateTime departPrevuLe,

        @NotNull
        LocalDateTime arriveePrevueLe,

        @NotNull
        @Positive
        Integer placesProposees,

        @NotNull
        @Positive
        Long idVehicule

) {
}
