package fr.tomallhen.covoiturage.horaire;

import fr.tomallhen.covoiturage.serviceentreprise.ServiceEntreprise;
import fr.tomallhen.covoiturage.serviceentreprise.ServiceEntrepriseRepository;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class HoraireService {

    private final HoraireRepository horaireRepository;
    private final ServiceEntrepriseRepository serviceEntrepriseRepository;

    public HoraireService(
            HoraireRepository horaireRepository,
            ServiceEntrepriseRepository serviceEntrepriseRepository
    ) {
        this.horaireRepository = horaireRepository;
        this.serviceEntrepriseRepository = serviceEntrepriseRepository;
    }

    public List<HoraireResponse> lister() {
        return horaireRepository.findAll().stream()
                .map(HoraireResponse::from)
                .toList();
    }

    public HoraireResponse consulter(Long id) {
        return HoraireResponse.from(trouverHoraire(id));
    }

    @Transactional
    public HoraireResponse creer(HoraireRequest request) {
        verifierHeures(request);
        ServiceEntreprise service = trouverService(request.idService());

        Horaire horaire = new Horaire(
                request.libelle().strip(),
                request.heureDebut(),
                request.heureFin(),
                service
        );

        return HoraireResponse.from(horaireRepository.save(horaire));
    }

    @Transactional
    public HoraireResponse modifier(Long id, HoraireRequest request) {
        Horaire horaire = trouverHoraire(id);
        verifierHeures(request);
        ServiceEntreprise service = trouverService(request.idService());

        horaire.setLibelle(request.libelle().strip());
        horaire.setHeureDebut(request.heureDebut());
        horaire.setHeureFin(request.heureFin());
        horaire.setServiceEntreprise(service);

        return HoraireResponse.from(horaire);
    }

    @Transactional
    public void supprimer(Long id) {
        horaireRepository.delete(trouverHoraire(id));
    }

    private Horaire trouverHoraire(Long id) {
        return horaireRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Horaire introuvable"
                ));
    }

    private ServiceEntreprise trouverService(Long id) {
        return serviceEntrepriseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Service d’entreprise introuvable"
                ));
    }

    private void verifierHeures(HoraireRequest request) {
        if (request.heureDebut().equals(request.heureFin())) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Les heures de début et de fin doivent être différentes"
            );
        }
    }
}