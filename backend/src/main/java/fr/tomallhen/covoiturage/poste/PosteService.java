package fr.tomallhen.covoiturage.poste;

import fr.tomallhen.covoiturage.serviceentreprise.ServiceEntreprise;
import fr.tomallhen.covoiturage.serviceentreprise.ServiceEntrepriseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class PosteService {

    private final PosteRepository posteRepository;
    private final ServiceEntrepriseRepository serviceEntrepriseRepository;

    public PosteService(
            PosteRepository posteRepository,
            ServiceEntrepriseRepository serviceEntrepriseRepository
    ) {
        this.posteRepository = posteRepository;
        this.serviceEntrepriseRepository = serviceEntrepriseRepository;
    }

    public List<PosteResponse> lister() {
        return posteRepository.findAll().stream()
                .map(PosteResponse::from)
                .toList();
    }

    public PosteResponse consulter(Long id) {
        return PosteResponse.from(trouverPoste(id));
    }

    @Transactional
    public PosteResponse creer(PosteRequest request) {
        ServiceEntreprise service = trouverService(request.idService());
        Poste poste = new Poste(request.nom().strip(), service);
        return PosteResponse.from(posteRepository.save(poste));
    }

    @Transactional
    public PosteResponse modifier(Long id, PosteRequest request) {
        Poste poste = trouverPoste(id);
        ServiceEntreprise service = trouverService(request.idService());

        poste.setNom(request.nom().strip());
        poste.setServiceEntreprise(service);

        return PosteResponse.from(poste);
    }

    @Transactional
    public void supprimer(Long id) {
        posteRepository.delete(trouverPoste(id));
    }

    private Poste trouverPoste(Long id) {
        return posteRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Poste introuvable"
                ));
    }

    private ServiceEntreprise trouverService(Long id) {
        return serviceEntrepriseRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Service d’entreprise introuvable"
                ));
    }
}