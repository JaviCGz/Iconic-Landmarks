package com.alkemy.icons.icons.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="continent")
@Getter
@Setter
public class ContinentEntity {

    @Id
    @GeneratedValue(Strategy =  GenerationType.SEQUENCE)
    private long id;
    private String image;
    @Column(name = "continent_name")
    private String continentName;

}
