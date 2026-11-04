package fr.tomallhen.covoiturage.poste;

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

import java.util.List;

@RestController
@RequestMapping("/api/postes")
public class PosteController {

    private final PosteService posteService;

    public PosteController(PosteService posteService) {
        this.posteService = posteService;
    }

    @GetMapping
    public List<PosteResponse> lister() {
        return posteService.lister();
    }

    @GetMapping("/{id}")
    public PosteResponse consulter(@PathVariable Long id) {
        return posteService.consulter(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PosteResponse creer(@Valid @RequestBody PosteRequest request) {
        return posteService.creer(request);
    }

    @PutMapping("/{id}")
    public PosteResponse modifier(
            @PathVariable Long id,
            @Valid @RequestBody PosteRequest request
    ) {
        return posteService.modifier(id, request);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void supprimer(@PathVariable Long id) {
        posteService.supprimer(id);
    }
}