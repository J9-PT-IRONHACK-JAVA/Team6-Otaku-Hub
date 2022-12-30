package com.ironhack.otakuhub.model;

import com.ironhack.otakuhub.config.StringListConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Anime {

    @Id
    private Long animeId;

    private String animeTitle;

    private String animeImg;

    private String status;

    private String type;

    private String releasedDate;

    @Convert(converter = StringListConverter.class)
    private List<String> genres;

    private String synopsis;

    private Integer totalEpisodes;

    @OneToMany
    private List<Episode> episodesList;

    @ManyToOne
    private Userr userr;

//    private Title titles;
//    private Double averageRating;
//    private String startDate;
//    private String endDate;
//    private String nextRelease;
//    private String subtype;
//    private String status;
//    private PosterImage posterImage;
//    private CoverImage coverImage;
//    private String nsfw;
//    private Integer episodeCount;
//    private Integer episodeLength;
//    private Genres genres;
//    private Categories categories;
//    private Reviews reviews;
//    private Episodes episodes;
//    private AnimeCharacters animeCharacters;

}




//
//@Data
//@Embeddable
//class Title{
//    private String en;
//    private String en_jp;
//    private String ja_jp;
//}
//
//@Data
//@Embeddable
//class PosterImage{
//    private String tiny;
//    private String large;
//    private String small;
//    private String original;
//
//}
//
//
//@Data
//@Embeddable
//class CoverImage{
//    private String tiny;
//    private String large;
//    private String small;
//    private String original;
//}
//
//@Data
//@Embeddable
//class Genres{
//    private Link links;
//}
//
//@Data
//@Embeddable
//class Categories{
//    private Link links;
//}
//
//@Data
//@Embeddable
//class Reviews{
//    private Link links;
//}
//
//@Data
//@Embeddable
//class Episodes{
//    private Link links;
//}
//
//@Data
//@Embeddable
//class AnimeCharacters{
//    private Link links;
//}
//
//@Data
//@Embeddable
//class Link{
//    private String self;
//    private String related;
//}
////
////
////
////{
////        "id": "12",
////        "type": "anime",
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12"
////        },
////        "attributes": {
////        "createdAt": "2013-02-20T16:00:25.722Z",
////        "updatedAt": "2022-12-28T15:20:50.335Z",
////        "slug": "one-piece",
////        "synopsis": "Gol D. Roger was known as the \"Pirate King,\" the strongest and most infamous being to have sailed the Grand Line. The capture and death of Roger by the World Government brought a change throughout the world. His last words before his death revealed the existence of the greatest treasure in the world, One Piece. It was this revelation that brought about the Grand Age of Pirates, men who dreamed of finding One Piece—which promises an unlimited amount of riches and fame—and quite possibly the pinnacle of glory and the title of the Pirate King.\nEnter Monkey D. Luffy, a 17-year-old boy who defies your standard definition of a pirate. Rather than the popular persona of a wicked, hardened, toothless pirate ransacking villages for fun, Luffy’s reason for being a pirate is one of pure wonder: the thought of an exciting adventure that leads him to intriguing people and ultimately, the promised treasure. Following in the footsteps of his childhood hero, Luffy and his crew travel across the Grand Line, experiencing crazy adventures, unveiling dark mysteries and battling strong enemies, all in order to reach the most coveted of all fortunes—One Piece.\n[Written by MAL Rewrite]",
////        "description": "Gol D. Roger was known as the \"Pirate King,\" the strongest and most infamous being to have sailed the Grand Line. The capture and death of Roger by the World Government brought a change throughout the world. His last words before his death revealed the existence of the greatest treasure in the world, One Piece. It was this revelation that brought about the Grand Age of Pirates, men who dreamed of finding One Piece—which promises an unlimited amount of riches and fame—and quite possibly the pinnacle of glory and the title of the Pirate King.\nEnter Monkey D. Luffy, a 17-year-old boy who defies your standard definition of a pirate. Rather than the popular persona of a wicked, hardened, toothless pirate ransacking villages for fun, Luffy’s reason for being a pirate is one of pure wonder: the thought of an exciting adventure that leads him to intriguing people and ultimately, the promised treasure. Following in the footsteps of his childhood hero, Luffy and his crew travel across the Grand Line, experiencing crazy adventures, unveiling dark mysteries and battling strong enemies, all in order to reach the most coveted of all fortunes—One Piece.\n[Written by MAL Rewrite]",
////        "coverImageTopOffset": 50,
////        "titles": {
////        "en": "One Piece",
////        "en_jp": "One Piece",
////        "ja_jp": "ONE PIECE"
////        },
////        "canonicalTitle": "One Piece",
////        "abbreviatedTitles": [
////        "ワンピース"
////        ],
////        "averageRating": "83.28",
////        "ratingFrequencies": {
////        "2": "8284",
////        "3": "183",
////        "4": "605",
////        "5": "124",
////        "6": "525",
////        "7": "115",
////        "8": "9475",
////        "9": "158",
////        "10": "1702",
////        "11": "244",
////        "12": "2859",
////        "13": "314",
////        "14": "21321",
////        "15": "700",
////        "16": "7843",
////        "17": "1209",
////        "18": "8447",
////        "19": "1192",
////        "20": "90897"
////        },
////        "userCount": 186101,
////        "favoritesCount": 6578,
////        "startDate": "1999-10-20",
////        "endDate": null,
////        "nextRelease": "2023-01-01T09:30:00.000+09:00",
////        "popularityRank": 14,
////        "ratingRank": 32,
////        "ageRating": "PG",
////        "ageRatingGuide": "Teens 13 or older",
////        "subtype": "TV",
////        "status": "current",
////        "tba": null,
////        "posterImage": {
////        "tiny": "https://media.kitsu.io/anime/poster_images/12/tiny.jpg",
////        "large": "https://media.kitsu.io/anime/poster_images/12/large.jpg",
////        "small": "https://media.kitsu.io/anime/poster_images/12/small.jpg",
////        "medium": "https://media.kitsu.io/anime/poster_images/12/medium.jpg",
////        "original": "https://media.kitsu.io/anime/poster_images/12/original.png",
////        "meta": {
////        "dimensions": {
////        "tiny": {
////        "width": 110,
////        "height": 156
////        },
////        "large": {
////        "width": 550,
////        "height": 780
////        },
////        "small": {
////        "width": 284,
////        "height": 402
////        },
////        "medium": {
////        "width": 390,
////        "height": 554
////        }
////        }
////        }
////        },
////        "coverImage": {
////        "tiny": "https://media.kitsu.io/anime/12/cover_image/tiny-cd1b0729d5c15400bfa2441ea3751e86.jpeg",
////        "large": "https://media.kitsu.io/anime/12/cover_image/large-3e72f400a87b5241780c5082f0582611.jpeg",
////        "small": "https://media.kitsu.io/anime/12/cover_image/small-8d0cbc39cac65d5d7c4db5f5b3742ae7.jpeg",
////        "original": "https://media.kitsu.io/anime/12/cover_image/21ecb556255bd46b95aea4779d19789f.jpg",
////        "meta": {
////        "dimensions": {
////        "tiny": {
////        "width": 840,
////        "height": 200
////        },
////        "large": {
////        "width": 3360,
////        "height": 800
////        },
////        "small": {
////        "width": 1680,
////        "height": 400
////        }
////        }
////        }
////        },
////        "episodeCount": null,
////        "episodeLength": 24,
////        "totalLength": 29136,
////        "youtubeVideoId": "CmTeYj2FmRc",
////        "showType": "TV",
////        "nsfw": false
////        },
////        "relationships": {
////        "genres": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/genres",
////        "related": "https://kitsu.io/api/edge/anime/12/genres"
////        }
////        },
////        "categories": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/categories",
////        "related": "https://kitsu.io/api/edge/anime/12/categories"
////        }
////        },
////        "castings": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/castings",
////        "related": "https://kitsu.io/api/edge/anime/12/castings"
////        }
////        },
////        "installments": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/installments",
////        "related": "https://kitsu.io/api/edge/anime/12/installments"
////        }
////        },
////        "mappings": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/mappings",
////        "related": "https://kitsu.io/api/edge/anime/12/mappings"
////        }
////        },
////        "reviews": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/reviews",
////        "related": "https://kitsu.io/api/edge/anime/12/reviews"
////        }
////        },
////        "mediaRelationships": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/media-relationships",
////        "related": "https://kitsu.io/api/edge/anime/12/media-relationships"
////        }
////        },
////        "characters": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/characters",
////        "related": "https://kitsu.io/api/edge/anime/12/characters"
////        }
////        },
////        "staff": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/staff",
////        "related": "https://kitsu.io/api/edge/anime/12/staff"
////        }
////        },
////        "productions": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/productions",
////        "related": "https://kitsu.io/api/edge/anime/12/productions"
////        }
////        },
////        "quotes": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/quotes",
////        "related": "https://kitsu.io/api/edge/anime/12/quotes"
////        }
////        },
////        "episodes": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/episodes",
////        "related": "https://kitsu.io/api/edge/anime/12/episodes"
////        }
////        },
////        "streamingLinks": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/streaming-links",
////        "related": "https://kitsu.io/api/edge/anime/12/streaming-links"
////        }
////        },
////        "animeProductions": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/anime-productions",
////        "related": "https://kitsu.io/api/edge/anime/12/anime-productions"
////        }
////        },
////        "animeCharacters": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/anime-characters",
////        "related": "https://kitsu.io/api/edge/anime/12/anime-characters"
////        }
////        },
////        "animeStaff": {
////        "links": {
////        "self": "https://kitsu.io/api/edge/anime/12/relationships/anime-staff",
////        "related": "https://kitsu.io/api/edge/anime/12/anime-staff"
////        }
////        }
////        }
////        }
