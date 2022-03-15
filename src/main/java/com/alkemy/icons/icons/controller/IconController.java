package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.BasicIconDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("icons")
public class IconController {

    @Autowired
    private IconService iconService;

    @GetMapping
    public ResponseEntity<List<BasicIconDTO>> getAll() {
        List<BasicIconDTO> icons = iconService.getAllBasicIcons();
        return ResponseEntity.ok().body(icons);
    }

    @GetMapping("/{id}")
    public ResponseEntity<IconDTO> getDetailedIcon(@PathVariable Long id) {
        IconDTO icon = iconService.getDetailsById(id);
        return ResponseEntity.ok(icon);
    }

    @PostMapping
    public ResponseEntity<IconDTO> save(@RequestBody IconDTO icon) {
        IconDTO savedIcon = iconService.save(icon);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedIcon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<IconDTO> update(@PathVariable Long id, @RequestBody IconDTO icon) {
        IconDTO result = iconService.update(id, icon);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        iconService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PostMapping("/{id}/countries/{idCountry}")
    public ResponseEntity<Void> addCountry(@PathVariable Long id, @PathVariable Long idCountry) {
        iconService.addCountry(id, idCountry);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/{id}/countries/{idCountry}")
    public ResponseEntity<Void> deleteCountry(@PathVariable Long id, @PathVariable Long idCountry) {
        iconService.removeCountry(id, idCountry);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/filters")
    public ResponseEntity<List<IconDTO>> getByFilters(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String date,
            @RequestParam(required = false) Set<Long> cities,
            @RequestParam(required = false, defaultValue = "ASC") String order
            ) {
        List<IconDTO> icons = iconService.getByFilters(name, date, cities, order);
        return ResponseEntity.ok().body(icons);
    }

}
