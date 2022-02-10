package com.alkemy.icons.icons.dto;

import com.alkemy.icons.icons.entity.CountryEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class IconDTO {
    private long id;
    private String image;
    private String iconName;
    private String creationDate;
    private long height;
    private String history;
    private List<CountryDTO> countries;
}