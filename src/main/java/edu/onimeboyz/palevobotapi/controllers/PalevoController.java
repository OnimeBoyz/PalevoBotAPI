package edu.onimeboyz.palevobotapi.controllers;


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


}
