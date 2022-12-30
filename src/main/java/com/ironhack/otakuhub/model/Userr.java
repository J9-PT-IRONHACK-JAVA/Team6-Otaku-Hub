package com.ironhack.otakuhub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;
import java.util.List;

import static com.ironhack.otakuhub.model.Level.NOOB;

@Entity
@Table(name = "users")
@Data
public class Userr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String roles;

    private Boolean isAccountNonLocked;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant lastUpdatedAt;

    private Integer points;

    private Level level;

    @OneToMany
    @JsonIgnore
    private List<Anime> animeList;

    @OneToMany
    @JsonIgnore
    private List<Quote> animeQuotes;


    public Userr(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        isAccountNonLocked = true;
        this.points = 0;
        this.level = NOOB;
    }

    public Userr() {
        isAccountNonLocked = true;
    }
}
