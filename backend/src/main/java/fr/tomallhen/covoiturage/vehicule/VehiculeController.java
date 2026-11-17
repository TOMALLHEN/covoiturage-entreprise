package fr.tomallhen.covoiturage.vehicule;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/vehicules")
public class VehiculeController {

    private final VehiculeService vehiculeService;

    public VehiculeController(VehiculeService vehiculeService) {
        this.vehiculeService = vehiculeService;
    }

    @GetMapping
    public List<VehiculeResponse> lister(Principal principal) {
        return vehiculeService.lister(principal.getName());
    }

    @GetMapping("/{id}")
    public VehiculeResponse consulter(
            @PathVariable Long id,
            Principal principal
    ) {
        return vehiculeService.consulter(id, principal.getName());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public VehiculeResponse creer(
            @Valid @RequestBody VehiculeRequest request,
            Principal principal
    ) {
        return vehiculeService.creer(request, principal.getName());
    }

    @PutMapping("/{id}")
    public VehiculeResponse modifier(
            @PathVariable Long id,
            @Valid @RequestBody VehiculeRequest request,
            Principal principal
    ) {
        return vehiculeService.modifier(id, request, principal.getName());
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimer(
            @PathVariable Long id,
            Principal principal
    ) {
        vehiculeService.supprimer(id, principal.getName());
    }
}