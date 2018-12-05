package edu.onimeboyz.palevobotapi.controllers;


import edu.onimeboyz.palevobotapi.entities.Comment;
import edu.onimeboyz.palevobotapi.entities.Palevo;
import edu.onimeboyz.palevobotapi.entities.User;
import edu.onimeboyz.palevobotapi.repositories.PalevoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/palevos")
public class PalevoController {
    PalevoRepository palevoRepository;

    @GetMapping
    public List<Palevo> getAllPalevos() {
        return palevoRepository.findAll();
    }

    @PostMapping
    public Palevo createPalevo(@Valid @RequestBody Palevo palevo) {
        return palevoRepository.save(palevo);
    }

    @GetMapping("/{palevo_id}")
    public Palevo getPalevoById(@PathVariable(value = "palevo_id") Integer palevoId) {
        return palevoRepository.findById(palevoId)
                .orElseThrow(() -> new IllegalArgumentException("Wrong palevo_id"));
    }

    @PutMapping("/{palevo_id}")
    public Palevo updateNote(@PathVariable(value = "palevo_id") Integer palevoId,
                              @Valid @RequestBody Palevo palevoDetails) {

        Palevo palevo = getPalevoById(palevoId);
        palevo.setTitle(palevoDetails.getTitle());
        palevo.setDescription(palevoDetails.getDescription());
        palevo.setRating(palevoDetails.getRating());
        palevo.setDocument(palevoDetails.getDocument());
        return palevoRepository.save(palevo);
    }

}
