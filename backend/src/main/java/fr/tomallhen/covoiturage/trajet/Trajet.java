
package fr.tomallhen.covoiturage.trajet;

import fr.tomallhen.covoiturage.auth.Salarie;
import fr.tomallhen.covoiturage.vehicule.Vehicule;
import fr.tomallhen.covoiturage.participation.Participation;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "trajets")
public class Trajet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_trajet")
    private Long idTrajet;

    @Column(name = "adresse_depart")
    private String adresseDepart;

    @Column(name = "latitude_depart")
    private Double latitudeDepart;

    @Column(name = "longitude_depart")
    private Double longitudeDepart;

    @Column(name = "adresse_arrivee")
    private String adresseArrivee;

    @Column(name = "latitude_arrivee")
    private Double latitudeArrivee;

    @Column(name = "longitude_arrivee")
    private Double longitudeArrivee;

    @Column(name = "depart_prevu_le")
    private LocalDateTime departPrevuLe;

    @Column(name = "arrivee_prevue_le")
    private LocalDateTime arriveePrevueLe;

    @Column(name = "places_proposees")
    private Integer placesProposees;

    @Column(name = "statut")
    private String statut;

    @Column(name = "termine_le")
    private LocalDateTime termineLe;

    @Column(name = "cree_le")
    private LocalDateTime creeLe;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_salarie", nullable = false)
    private Salarie conducteur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_vehicule", nullable = false)
    private Vehicule vehicule;

    @OneToMany(mappedBy = "trajet")
    private List<Participation> participations = new ArrayList<>();
}
