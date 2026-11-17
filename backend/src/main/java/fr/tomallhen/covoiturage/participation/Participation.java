package fr.tomallhen.covoiturage.participation;

import fr.tomallhen.covoiturage.auth.Salarie;
import fr.tomallhen.covoiturage.trajet.Trajet;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(
        name = "participations",
        uniqueConstraints = @UniqueConstraint(
                name = "uq_participations_salarie_trajet",
                columnNames = {"id_salarie", "id_trajet"}
        )
)
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_participation")
    private Long idParticipation;

    @Column(name = "statut")
    private String statut;

    @Column(name = "reserve_le")
    private LocalDateTime reserveLe;

    @Column(name = "valide_le")
    private LocalDateTime valideLe;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_salarie", nullable = false)
    private Salarie salarie;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_trajet", nullable = false)
    private Trajet trajet;

    public Participation() {
    }

    public Long getIdParticipation() {
        return idParticipation;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public LocalDateTime getReserveLe() {
        return reserveLe;
    }

    public void setReserveLe(LocalDateTime reserveLe) {
        this.reserveLe = reserveLe;
    }

    public LocalDateTime getValideLe() {
        return valideLe;
    }

    public void setValideLe(LocalDateTime valideLe) {
        this.valideLe = valideLe;
    }

    public Salarie getSalarie() {
        return salarie;
    }

    public void setSalarie(Salarie salarie) {
        this.salarie = salarie;
    }

    public Trajet getTrajet() {
        return trajet;
    }

    public void setTrajet(Trajet trajet) {
        this.trajet = trajet;
    }
}