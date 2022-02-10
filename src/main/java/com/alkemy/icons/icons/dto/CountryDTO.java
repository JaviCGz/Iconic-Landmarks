package com.alkemy.icons.icons.dto;

import com.alkemy.icons.icons.entity.ContinentEntity;
import com.alkemy.icons.icons.entity.IconEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class CountryDTO {
    private long id;
    private String image;
    private String countryName;
    private long population;
    private long area;
    private ContinentEntity continent;
    private long continentId;
    private Set<IconEntity> icons = new HashSet<>();
}
