package com.alkemy.icons.icons.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IconDTO {
    private Long id;
    private String image;
    private String iconName;
    private String creationDate;
    private Long height;
    private String history;
    private List<CountryDTO> countries;
}