package com.ironhack.otakuhub.model;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Episode {

    @Id
    private Long episodeId;

    private String episodeNum;

    @ManyToOne
    private Episode episode;
}
