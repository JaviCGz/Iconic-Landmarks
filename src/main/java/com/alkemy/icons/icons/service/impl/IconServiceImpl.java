package com.alkemy.icons.icons.service.impl;

import com.alkemy.icons.icons.dto.BasicIconDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.entity.CountryEntity;
import com.alkemy.icons.icons.entity.IconEntity;
import com.alkemy.icons.icons.exception.ParamNotFound;
import com.alkemy.icons.icons.mapper.IconMapper;
import com.alkemy.icons.icons.repository.IconRepository;
import com.alkemy.icons.icons.repository.specification.IconSpecification;
import com.alkemy.icons.icons.service.CountryService;
import com.alkemy.icons.icons.service.IconService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class IconServiceImpl implements IconService {

    IconMapper iconMapper;
    IconRepository iconRepository;
    private IconSpecification iconSpecification; //TODO: Write the code of this class
    private final CountryService countryService;

    @Autowired
    public IconServiceImpl(IconMapper iconMapper,
                           IconRepository iconRepository,
                           IconSpecification iconSpecification,
                           CountryService countryService) {
        this.iconMapper = iconMapper;
        this.iconRepository = iconRepository;
        this.countryService = countryService;
    }

    public IconDTO save(IconDTO dto) {
        IconEntity entity = iconMapper.convertToEntity(dto);
        IconEntity entitySaved = iconRepository.save(entity);
        return iconMapper.convertToDto(entitySaved, true);
    }

    public IconDTO update(Long id, IconDTO iconDTO) {
        Optional<IconEntity> entity = iconRepository.findById(id);
        if (!entity.isPresent()) {
            throw new ParamNotFound("Invalid icon ID");
        }
        iconMapper.RefreshValues(entity.get(), iconDTO);
        IconEntity entitySaved = iconRepository.save(entity.get());
        return iconMapper.convertToDto(entitySaved, false); //I avoid result variable
    }

    public void delete(Long id) {
        iconRepository.deleteById(id);
    }

    public void addCountry(Long id, Long idCountry) {
        IconEntity entity = iconRepository.getById(id);
//        entity.getCountries().size(); TODO:It doesn't have sense
        CountryEntity country = countryService.getEntityById(idCountry);
        entity.addCountry(country);
        iconRepository.save(entity);
    }

    public void removeCountry(Long id, Long idCountry) {
        IconEntity entity = iconRepository.getById(id);
        CountryEntity country = countryService.getEntityById(idCountry);
        entity.removeCountry(country);
        iconRepository.save(entity);
    }

    public List<BasicIconDTO> getAllBasicIcons() {
        List<IconEntity> entities = iconRepository.findAll();
        return iconMapper.convertToBasicDtoList(entities);
    }

    public IconDTO getDetailsById(Long id) {
        Optional<IconEntity> entity = iconRepository.findById(id);
        if(!entity.isPresent()) {
            throw new ParamNotFound("Invalid icon ID");
        }
        return iconMapper.convertToDto(entity.get(), true);
    }

    public List<IconDTO> getByFilters(String name, String date, Set<Long> cities, String order) {
        return null;
    }
    //TODO: 2° Develop the logic of this method
    //TODO: 1° Create IconFiltersDTO class and THEN complete getByFilters method

}