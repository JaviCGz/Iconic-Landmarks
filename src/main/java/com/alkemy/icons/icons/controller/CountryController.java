package com.alkemy.icons.icons.controller;

import com.alkemy.icons.icons.dto.BasicCountryDTO;
import com.alkemy.icons.icons.dto.CountryDTO;
import com.alkemy.icons.icons.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("countries")
public class CountryController {

    @Autowired
    CountryService countryService;

    @PostMapping
    public ResponseEntity<CountryDTO> save(@RequestBody CountryDTO country) {
        CountryDTO savedCountry = countryService.save(country);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCountry);
    }

    @GetMapping
    public ResponseEntity<List<BasicCountryDTO>> getAll() {
        List<BasicCountryDTO> countries = countryService.getAllBasicCountries();
        return ResponseEntity.ok().body(countries);
    }
}
