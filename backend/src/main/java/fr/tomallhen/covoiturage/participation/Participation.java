package fr.tomallhen.covoiturage.participation;

import fr.tomallhen.covoiturage.auth.Salarie;
import fr.tomallhen.covoiturage.trajet.Trajet;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "participations")
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
}