package fr.tomallhen.covoiturage.serviceentreprise;

import java.net.URI;
import java.util.List;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/services")
public class ServiceEntrepriseController {

    private final ServiceEntrepriseService service;

    public ServiceEntrepriseController(
            ServiceEntrepriseService service
    ) {
        this.service = service;
    }

    @GetMapping
    public List<ServiceEntrepriseResponse> lister() {
        return service.lister();
    }

    @GetMapping("/{id}")
    public ServiceEntrepriseResponse consulter(
            @PathVariable("id") Long id
    ) {
        return service.consulter(id);
    }

    @PostMapping
    public ResponseEntity<ServiceEntrepriseResponse> creer(
            @Valid @RequestBody ServiceEntrepriseRequest request
    ) {
        ServiceEntrepriseResponse resultat = service.creer(request);

        return ResponseEntity
                .created(URI.create("/api/services/" + resultat.id()))
                .body(resultat);
    }

    @PutMapping("/{id}")
    public ServiceEntrepriseResponse modifier(
            @PathVariable("id") Long id,
            @Valid @RequestBody ServiceEntrepriseRequest request
    ) {
        return service.modifier(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(
            @PathVariable("id") Long id
    ) {
        service.supprimer(id);

        return ResponseEntity.noContent().build();
    }
}