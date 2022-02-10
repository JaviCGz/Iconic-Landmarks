package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.ContinentDTO;
import com.alkemy.icons.icons.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("continents")
public class ContinentController {

    @Autowired
    private ContinentService continentService;

    @PostMapping
    public ResponseEntity<ContinentDTO> save(@RequestBody ContinentDTO continent) {
        ContinentDTO savedContinent = continentService.save(continent);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedContinent);
    }

    @GetMapping
    public ResponseEntity<List<ContinentDTO>> getAll() {
        List<ContinentDTO> continents = continentService.getAllContinents();
        return ResponseEntity.ok().body(continents);
    }
}
