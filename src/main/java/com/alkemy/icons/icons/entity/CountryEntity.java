package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "country")
@Getter
@Setter
public class CountryEntity {

    private long id;
    private String image;
    @Column(name = "country_name")
    private String countryName;
    private long population;
    private long area;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "continent_id", insertable = false, updatable = false)
    private ContinentEntity continent;
    @Column(name = "continent_id", nullable = false)
    private long continentId;

    @ManyToMany(
            cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(name = "icon_country", joinColumns = @JoinColumn(name = "country_id"), inverseJoinColumns = @JoinColumn(name = "icon_id"))
    private Set<IconEntity> icons = new HashSet<>();

    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final CountryEntity other = (CountryEntity) obj;
        return other.id;
    }
}
