package fr.tomallhen.covoiturage.trajet;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
@RequestMapping("/api/trajets")
public class TrajetController {

    private final TrajetService trajetService;

    public TrajetController(TrajetService trajetService) {
        this.trajetService = trajetService;
    }

    @GetMapping
    public List<TrajetResponse> lister() {
        return trajetService.lister();
    }

    @GetMapping("/mes-trajets")
    public List<TrajetResponse> listerMesTrajets(Principal principal) {
        return trajetService.listerMesTrajets(principal.getName());
    }

    @GetMapping("/{id}")
    public TrajetResponse consulter(@PathVariable Long id) {
        return trajetService.consulter(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public TrajetResponse creer(
            @Valid @RequestBody TrajetRequest request,
            Principal principal
    ) {
        return trajetService.creer(request, principal.getName());
    }

    @PutMapping("/{id}")
    public TrajetResponse modifier(
            @PathVariable Long id,
            @Valid @RequestBody TrajetRequest request,
            Principal principal
    ) {
        return trajetService.modifier(id, request, principal.getName());
    }

    @PostMapping("/{id}/annulation")
    public TrajetResponse annuler(
            @PathVariable Long id,
            Principal principal
    ) {
        return trajetService.annuler(id, principal.getName());
    }
}