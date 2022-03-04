package com.alkemy.icons.icons.dto;

import com.alkemy.icons.icons.entity.ContinentEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryDTO {
    private Long id;
    private String image;
    private String countryName;
    private Long population;
    private Long area;
    private ContinentEntity continent;
    private Long continentId;
    private List<IconDTO> icons;
}
