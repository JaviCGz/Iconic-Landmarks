package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.BasicIconDTO;
import com.alkemy.icons.icons.dto.CountryDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
public class IconMapper {

    @Autowired
    CountryMapper countryMapper;

    /*-------------------------------------Conversions---------------------------------------------*/

    public IconEntity convertToEntity(IconDTO dto) {
        IconEntity entity = new IconEntity();
        entity.setImage(dto.getImage());
        entity.setIconName(dto.getIconName());
        entity.setCreationDate(this.convertStringToLocalDate(dto.getCreationDate()));
        entity.setHeight(dto.getHeight());
        entity.setHistory(dto.getHistory());
        return entity;
    }

    public IconDTO convertToDto(IconEntity entity, boolean loadCountries) {
        IconDTO dto = new IconDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setIconName(entity.getIconName());
        dto.setCreationDate(entity.getCreationDate().toString());
        dto.setHeight(entity.getHeight());
        dto.setHistory(entity.getHistory());
        if (loadCountries) {
            List<CountryDTO> countriesDto = countryMapper.convertToDtoList(entity.getCountries(), false);
            dto.setCountries(countriesDto);
        }
        return dto;
    }

    public List<IconDTO> convertToDtoList(Collection<IconEntity> entities, boolean loadCountries) {
        List<IconDTO> dtoList = new ArrayList<>();
        for (IconEntity entity : entities) {
            dtoList.add(convertToDto(entity, loadCountries)); //TODO: Se está pasando en falso el load?
        }
        return dtoList;
    }

    public List<BasicIconDTO> convertToBasicDtoList(List<IconEntity> entities) {
        List<BasicIconDTO> basicDtoList = new ArrayList<>();
        for (IconEntity entity : entities) {
            basicDtoList.add(convertToBasicDto(entity));
        }
        return basicDtoList;
    }

    public Set<IconEntity> convertToEntityList(List<IconDTO> dtoList) {
        Set<IconEntity> entities = new HashSet<>();
        for (IconDTO dto : dtoList) {
            entities.add(convertToEntity(dto));
        }
        return entities;
    }

    public void RefreshValues(IconEntity entity, IconDTO iconDTO) {
        entity.setImage(iconDTO.getImage());
        entity.setIconName(iconDTO.getIconName());
        entity.setCreationDate(convertStringToLocalDate(iconDTO.getCreationDate()));
        entity.setHeight(iconDTO.getHeight());
        entity.setHistory(iconDTO.getHistory());
    }
    /*----------------------------------Internal class methods---------------------------------------*/

    private LocalDate convertStringToLocalDate (String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(stringDate, formatter);
    }

    private BasicIconDTO convertToBasicDto(IconEntity entity) {
        BasicIconDTO basicDto = new BasicIconDTO();
        basicDto.setId(entity.getId());
        basicDto.setImage(entity.getImage());
        basicDto.setIconName(entity.getIconName());
        return basicDto;
    }

}
