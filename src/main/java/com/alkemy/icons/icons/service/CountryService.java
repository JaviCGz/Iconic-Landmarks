package com.alkemy.icons.icons.service;

import com.alkemy.icons.icons.dto.BasicCountryDTO;
import com.alkemy.icons.icons.dto.CountryDTO;

import java.util.List;

public interface CountryService {

    CountryDTO save(CountryDTO dto);
    List<BasicCountryDTO> getAllBasicCountries();
}
