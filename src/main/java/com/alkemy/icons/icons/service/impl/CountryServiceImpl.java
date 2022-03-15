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

    CountryMapper countryMapper;
    CountryRepository countryRepository;

    @Autowired
    public CountryServiceImpl(CountryMapper countryMapper, CountryRepository countryRepository) {
        this.countryMapper = countryMapper;
        this.countryRepository = countryRepository;
    }

    public CountryDTO save(CountryDTO dto) {
        CountryEntity entity = countryMapper.convertToEntity(dto);
        CountryEntity entitySaved = countryRepository.save(entity);
        return countryMapper.convertToDto(entitySaved, true);
    }

    public List<BasicCountryDTO> getAllBasicCountries() {
        List<CountryEntity> entities = countryRepository.findAll();
/*      List<CountryDTO> dtoList = countryMapper.convertToDtoList(entities, true);
It makes not sense to create a dto list that is never used
*/
        return countryMapper.convertToBasicDtoList(entities, false);
    }

    public CountryEntity getEntityById(Long id) {
        return countryRepository.getById(id);
    }
}

/*TODO: Demo project's method named "getAllBasicCountries" brings all the information
   instead of required basic information */