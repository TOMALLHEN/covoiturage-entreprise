package fr.tomallhen.covoiturage.participation;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/participations")
public class ParticipationController {

    private final ParticipationService participationService;

    public ParticipationController(
            ParticipationService participationService
    ) {
        this.participationService = participationService;
    }

    @GetMapping
    public List<ParticipationResponse> listerMesParticipations(
            Principal principal
    ) {
        return participationService.listerMesParticipations(
                principal.getName()
        );
    }

    @GetMapping("/trajet/{idTrajet}")
    public List<ParticipationResponse> listerPourTrajet(
            @PathVariable Long idTrajet,
            Principal principal
    ) {
        return participationService.listerPourTrajet(
                idTrajet,
                principal.getName()
        );
    }

    @PostMapping
    public ParticipationResponse reserver(
            @Valid @RequestBody ParticipationRequest request,
            Principal principal
    ) {
        return participationService.reserver(request, principal.getName());
    }

    @PostMapping("/{id}/annulation")
    public ParticipationResponse annuler(
            @PathVariable Long id,
            Principal principal
    ) {
        return participationService.annuler(id, principal.getName());
    }

    @PostMapping("/{id}/validation")
    public ParticipationResponse valider(
            @PathVariable Long id,
            Principal principal
    ) {
        return participationService.valider(id, principal.getName());
    }
}