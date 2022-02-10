package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.BasicCountryDTO;
import com.alkemy.icons.icons.dto.CountryDTO;
import com.alkemy.icons.icons.entity.CountryEntity;
import com.alkemy.icons.icons.mapper.CountryMapper;
import com.alkemy.icons.icons.repository.CountryRepository;
import com.alkemy.icons.icons.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    CountryMapper countryMapper;

    @Autowired
    CountryRepository countryRepository;

    public CountryDTO save(CountryDTO dto) {
        CountryEntity entity = countryMapper.convertToEntity(dto);
        CountryEntity entitySaved = countryRepository.save(entity);
        CountryDTO result = countryMapper.convertToDto(entitySaved);
        return result;
    }

    public List<BasicCountryDTO> getAllBasicCountries() {
        List<CountryEntity> entities = countryRepository.findAll();
        List<BasicCountryDTO> result = countryMapper.convertAllToBasicDto(entities);
        return result;
    }
}
