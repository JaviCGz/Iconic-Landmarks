package com.alkemy.icons.icons.mapper;

import com.alkemy.icons.icons.dto.ContinentDTO;
import com.alkemy.icons.icons.entity.ContinentEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ContinentMapper {

    public ContinentEntity convertToEntity(ContinentDTO dto) {

        ContinentEntity entity = new ContinentEntity();
        entity.setImage(dto.getImage());
        entity.setContinentName(dto.getContinentName());
        return entity;
    }

    public ContinentDTO convertToDto(ContinentEntity entity) {

        ContinentDTO dto = new ContinentDTO();
        dto.setId(entity.getId());
        dto.setImage(entity.getImage());
        dto.setContinentName(entity.getContinentName());
        return dto;
    }

    public List<ContinentDTO> convertAllToDto(List<ContinentEntity> entities) {
        List<ContinentDTO> dtoList = new ArrayList<>();
        for (ContinentEntity entity : entities) {
            dtoList.add(convertToDto(entity));
        }
        return dtoList;
    }
}
