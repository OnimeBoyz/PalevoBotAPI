package edu.onimeboyz.palevobotapi.controllers;


import edu.onimeboyz.palevobotapi.entities.Palevo;
import edu.onimeboyz.palevobotapi.entities.User;
import edu.onimeboyz.palevobotapi.repositories.PalevoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/palevos")
public class PalevoController {
    PalevoRepository palevoRepository;

    @GetMapping
    public List<Palevo> getAllPalevos() {
        return palevoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Palevo getPalevoById(@PathVariable Integer id) {
        return palevoRepository.findById(id).get();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePalevo(@PathVariable(value = "id") Integer palevoId) {
        Palevo palevo = palevoRepository.findById(palevoId).get();

        palevoRepository.delete(palevo);
        return ResponseEntity.ok().build();
    }
}
