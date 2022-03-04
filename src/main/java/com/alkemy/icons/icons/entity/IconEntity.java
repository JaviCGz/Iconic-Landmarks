package com.alkemy.icons.icons.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "icon")
@Getter
@Setter
@SQLDelete(sql = "UPDATE icon SET deleted = true WHERE id=?")
@Where(clause = "deleted = false")
public class IconEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    @Column(name = "icon_name")
    private String iconName;

    @Column(name = "creation_date", nullable = false)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private LocalDate creationDate;

    private Long height;

    private String history;

    private boolean deleted = Boolean.FALSE;

    @ManyToMany(mappedBy = "icons", cascade = CascadeType.ALL)
    private List<CountryEntity> countries = new ArrayList<>();

    //Add and delete countries
    public void addCountry(CountryEntity country) {
        this.countries.add(country);
    }
    public void removeCountry(CountryEntity country) {
        this.countries.remove(country);
    }
}