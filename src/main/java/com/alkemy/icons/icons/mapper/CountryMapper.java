package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.BasicCountryDTO;
import com.alkemy.icons.icons.dto.CountryDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.entity.ContinentEntity;
import com.alkemy.icons.icons.entity.CountryEntity;
import com.alkemy.icons.icons.repository.ContinentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CountryMapper {

    @Autowired
    private IconMapper iconMapper;

    @Autowired
    private ContinentRepository continentRepository;

    public CountryEntity convertToEntity (CountryDTO dto) {
        CountryEntity entity = new CountryEntity();
        entity.setImage(dto.getImage());
        entity.setCountryName(dto.getCountryName());
        entity.setPopulation(dto.getPopulation());
        entity.setArea(dto.getArea());
        entity.setContinentId(dto.getContinentId());
// ---------Icons---------
        if (!(dto.getIcons() == null || dto.getIcons().size() == 0)) {
            entity.setIcons(iconMapper.lookForOrCreateIcons(dto.getIcons()));
            /*entity.setIcons(iconMapper.convertToEntityList(dto.getIcons()));*/
        }
        return entity;
    }

    public CountryDTO convertToDto (CountryEntity entity, boolean loadIcons) {
        CountryDTO dto = new CountryDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setCountryName(entity.getCountryName());
        dto.setPopulation(entity.getPopulation());
        dto.setArea(entity.getArea());
        dto.setContinentId(entity.getContinentId());
        if (loadIcons) {
                List<IconDTO> dtoList = iconMapper.convertToDtoList(entity.getIcons(), false);
                dto.setIcons(dtoList);
        } else {
            dto.setIcons(null);
        }
        return dto;
    }

    public List<CountryDTO> convertToDtoList(List<CountryEntity> entities, boolean loadIcons) {
        List<CountryDTO> dtoList = new ArrayList<>();
        for (CountryEntity entity : entities) {
            dtoList.add(convertToDto(entity, loadIcons));
        }
        return dtoList;
    }

    public List<BasicCountryDTO> convertToBasicDtoList(List<CountryEntity> entities, boolean loadIcons) {
        List<BasicCountryDTO> basicDtoList = new ArrayList<>();
        for (CountryEntity entity : entities) {
            basicDtoList.add(convertToBasicDto(entity));
        }
        return basicDtoList;
    }

    public List<CountryEntity> convertToEntityList(List<CountryDTO> dtoList) {
        List<CountryEntity> entities = new ArrayList<>();
        for(CountryDTO dto : dtoList) {
            entities.add(convertToEntity(dto));
        }
        return entities;
    }

    /*----------------------------------Internal class methods---------------------------------------*/

    private BasicCountryDTO convertToBasicDto (CountryEntity entity) {
        BasicCountryDTO basicDto = new BasicCountryDTO();
        basicDto.setImage(entity.getImage());
        basicDto.setCountryName(entity.getCountryName());
        Optional<ContinentEntity> continent = continentRepository.findById(entity.getContinentId());
        if (continent.isPresent()) {
            basicDto.setContinent(continent.get().getContinentName());
        }
/*
        continent.ifPresent(continentEntity -> basicDto.setContinent(continentEntity.getContinentName()));
*/
        basicDto.setPopulation(entity.getPopulation());
        return basicDto;
    }

}
