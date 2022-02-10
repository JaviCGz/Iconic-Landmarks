package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.BasicCountryDTO;
import com.alkemy.icons.icons.dto.CountryDTO;
import com.alkemy.icons.icons.entity.CountryEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CountryMapper {

    public CountryEntity convertToEntity (CountryDTO dto) {
        CountryEntity entity = new CountryEntity();
        entity.setImage(dto.getImage());
        entity.setCountryName(dto.getCountryName());
        entity.setPopulation(dto.getPopulation());
        entity.setArea(dto.getArea());
        entity.setContinent(dto.getContinent());
        entity.setContinentId(dto.getContinentId());
        entity.setIcons(dto.getIcons());
        return entity;
    }


    public CountryDTO convertToDto (CountryEntity entity) {
        CountryDTO dto = new CountryDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setCountryName(entity.getCountryName());
        dto.setPopulation(entity.getPopulation());
        dto.setArea(entity.getArea());
        dto.setContinent(entity.getContinent());
        dto.setContinentId(entity.getContinentId());
        dto.setIcons(entity.getIcons());
        return dto;
    }

    public BasicCountryDTO convertToBasicDto (CountryEntity entity) {
        BasicCountryDTO basicDto = new BasicCountryDTO();
        basicDto.setImage(entity.getImage());
        basicDto.setCountryName(entity.getCountryName());
        basicDto.setPopulation(entity.getPopulation());
        return basicDto;
    }

    public List<CountryDTO> convertAllToDto(List<CountryEntity> entities, boolean loadCountries) {
        List<CountryDTO> dtoList = new ArrayList<>();
        for (CountryEntity entity : entities) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }

    public List<BasicCountryDTO> convertAllToBasicDto (List<CountryEntity> entities) {
        List<BasicCountryDTO> basicDtoList = new ArrayList<>();
        for (CountryEntity entity : entities) {
            basicDtoList.add(convertToBasicDto(entity));
        }
        return basicDtoList;
    }
}
