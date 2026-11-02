package fr.tomallhen.covoiturage.serviceentreprise;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ServiceEntrepriseService {

    private final ServiceEntrepriseRepository repository;

    public ServiceEntrepriseService(
            ServiceEntrepriseRepository repository
    ) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<ServiceEntrepriseResponse> lister() {
        return repository.findAll()
                .stream()
                .map(ServiceEntrepriseResponse::from)
                .toList();
    }

    @Transactional(readOnly = true)
    public ServiceEntrepriseResponse consulter(Long id) {
        return ServiceEntrepriseResponse.from(rechercher(id));
    }

    @Transactional
    public ServiceEntrepriseResponse creer(
            ServiceEntrepriseRequest request
    ) {
        ServiceEntreprise serviceEntreprise =
                new ServiceEntreprise(request.nom().strip());

        return enregistrer(serviceEntreprise);
    }

    @Transactional
    public ServiceEntrepriseResponse modifier(
            Long id,
            ServiceEntrepriseRequest request
    ) {
        ServiceEntreprise serviceEntreprise = rechercher(id);

        serviceEntreprise.setNom(request.nom().strip());

        return enregistrer(serviceEntreprise);
    }

    @Transactional
    public void supprimer(Long id) {
        ServiceEntreprise serviceEntreprise = rechercher(id);

        try {
            repository.delete(serviceEntreprise);
            repository.flush();
        } catch (DataIntegrityViolationException exception) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Ce service est encore utilisé.",
                    exception
            );
        }
    }

    private ServiceEntreprise rechercher(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Service introuvable."
                ));
    }

    private ServiceEntrepriseResponse enregistrer(
            ServiceEntreprise serviceEntreprise
    ) {
        try {
            ServiceEntreprise resultat =
                    repository.saveAndFlush(serviceEntreprise);

            return ServiceEntrepriseResponse.from(resultat);

        } catch (DataIntegrityViolationException exception) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "Impossible d'enregistrer ce service : "
                            + "vérifiez notamment que son nom est unique.",
                    exception
            );
        }
    }
}