package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.BasicIconDTO;
import com.alkemy.icons.icons.dto.CountryDTO;
import com.alkemy.icons.icons.dto.IconDTO;
import com.alkemy.icons.icons.entity.IconEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class IconMapper {

    @Autowired
    CountryMapper countryMapper;

    public IconEntity convertToEntity(IconDTO dto) {
        IconEntity entity = new IconEntity();
        entity.setImage(dto.getImage());
        entity.setIconName(dto.getIconName());
        entity.setCreationDate(this.convertStringToLocalDate(dto.getCreationDate()));
        entity.setHeight(dto.getHeight());
        entity.setHistory(dto.getHistory());
//        entity.setCountries(dto.getCountries()); //TODO: ¿Por qué no agregó la lista al convertir y guardar?
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
            List<CountryDTO> countriesDto = countryMapper.convertAllToDto(entity.getCountries(), false);
            dto.setCountries(countriesDto);
        }
        return dto;
    }

    public BasicIconDTO convertToBasicDto(IconEntity entity) {
        BasicIconDTO basicDto = new BasicIconDTO();
        basicDto.setImage(entity.getImage());
        basicDto.setIconName(entity.getIconName());
        return basicDto;
    }

    public List<IconDTO> convertAllToDto(List<IconEntity> entities, boolean loadCountries) {
        List<IconDTO> dtoList = new ArrayList<>();
        for (IconEntity entity : entities) {
            dtoList.add(convertToDto(entity, loadCountries));
        }
        return dtoList;
    }

    public List<BasicIconDTO> convertAllToBasicDto (List<IconEntity> entities) {
        List<BasicIconDTO> basicDtoList = new ArrayList<>();
        for (IconEntity entity : entities) {
            basicDtoList.add(convertToBasicDto(entity));
        }
        return basicDtoList;
    }

    /*-------------------------------------------------------------------------*/

    private LocalDate convertStringToLocalDate (String stringDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(stringDate, formatter); //Omití la variable y retorné directamente
    }

}
