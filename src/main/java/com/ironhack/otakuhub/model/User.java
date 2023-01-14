package com.ironhack.otakuhub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.otakuhub.enums.Level;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Tolerate;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static com.ironhack.otakuhub.enums.Level.NOOB;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;

    private String password;
    private String roles;
    private Boolean isAccountNonLocked;
    @CreationTimestamp
    private Instant createdAt;
    @UpdateTimestamp
    private Instant lastUpdatedAt;

    @Setter (AccessLevel.NONE)
    private Integer points;
    private Level level;

    @ManyToMany
    //@JsonIgnore
    private List<Anime> animeList;

    @OneToMany
    //@JsonIgnore
    private List<Quote> animeQuotes;

    //private static  PasswordEncoder passwordEncoder ;


    public User(String username, String password, String roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        isAccountNonLocked = true;
        this.points = 0;
        this.level = NOOB;
        this.animeList = new ArrayList<Anime>();
        this.animeQuotes = new ArrayList<Quote>();
    }

    public User() {
        isAccountNonLocked = true;
    }

    public void addAnimeToAnimeList(Anime animeToAdd) {
        boolean animeIsInTheList = false;
        for (Anime anime: animeList) {
            if (anime.getAnimeTitle().equals(animeToAdd.getAnimeTitle())) {
                animeIsInTheList = true;
            }
        }
        if (!animeIsInTheList) {
            animeList.add(animeToAdd);
        }

    }

   // public void setPassword(String password) {
   //     this.password = passwordEncoder.encode(password);
   // }



    public void setPoints(Integer points) {
        this.points = points;
        if(this.points>100){
            this.setLevel(Level.GOLD);
        } else if (this.points>50) {
            this.setLevel(Level.SILVER);
        } else if (this.points>10) {
            this.setLevel(Level.BRONZE);
        } else if (this.points <=10) {
        this.setLevel(Level.NOOB);
    }
    }

    public void addQuoteToQuoteList(Quote quote) {
        animeQuotes.add(quote);
    }

    public void addPoints () {
        this.points++;
        if(this.points>100){
            this.setLevel(Level.GOLD);
        } else if (this.points>50) {
            this.setLevel(Level.SILVER);
        } else if (this.points>10) {
            this.setLevel(Level.BRONZE);
        } else if (this.points <=10) {
            this.setLevel(Level.NOOB);
        }

    }

}
