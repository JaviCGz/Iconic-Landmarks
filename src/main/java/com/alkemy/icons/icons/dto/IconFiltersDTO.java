package com.alkemy.icons.icons.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class IconFiltersDTO {
    private String iconName;
    private String creationDate;
    private Set<Long> countries;
    private String order;

    public IconFiltersDTO(String iconName, String creationDate, Set<Long> countries, String order) {
        this.iconName = iconName;
        this.creationDate = creationDate;
        this.countries = countries;
        this.order = order;
    }

    public boolean isASC() {
        return this.order.compareToIgnoreCase("ASC") == 0;
    }

    public boolean isDESC() {
        return this.order.compareToIgnoreCase("DESC") == 0;
    }
}