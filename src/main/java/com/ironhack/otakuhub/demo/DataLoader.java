package com.ironhack.otakuhub.demo;

import com.ironhack.otakuhub.model.AnimeSceneImage;
import com.ironhack.otakuhub.model.User;
import com.ironhack.otakuhub.repository.AnimeSceneImageRepository;
import com.ironhack.otakuhub.repository.UserRepository;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
@RequiredArgsConstructor
@Log
@Profile("demo")
public class DataLoader {
    private final AnimeSceneImageRepository animeSceneImageRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void storeUser(){
       try {
            log.info("Starting demo user loading...");
            User user1 = new User("user", passwordEncoder.encode("user"), "ROLE_USER");
            userRepository.save(user1);
            log.info("User " + user1.getUsername() + " was created successfully");

            User user2 = new User("admin", passwordEncoder.encode("admin"), "ROLE_USER,ROLE_ADMIN");
            userRepository.save(user2);
            log.info("User " + user2.getUsername() + " was created successfully");
            log.info("Finished demo user loading.");

           User user3 = new User("admin2", passwordEncoder.encode("admin2"), "ROLE_USER,ROLE_ADMIN");
           userRepository.save(user3);
           log.info("User " + user3.getUsername() + " was created successfully");
           log.info("Finished demo user loading.");


        } catch (Exception e){
           System.out.println("Users exist already in the database");
           System.out.println(e.getMessage());
           System.out.println(e.getCause());

       }
    }
    @EventListener(ApplicationReadyEvent.class)
    public void loadAnimeSceneImages(){
        try{
            var animeSceneImages = new ArrayList<AnimeSceneImage>(List.of(
 //               ONEPIECE urls
                    new AnimeSceneImage("https://i.ytimg.com/vi/ijxqbG4_IDs/maxresdefault.jpg"),
                    new AnimeSceneImage("https://qph.cf2.quoracdn.net/main-qimg-9fa6865e15516fe240dfb758b49769ed-lq"),
                    new AnimeSceneImage("https://imgix.ranker.com/list_img_v2/14221/3194221/original/3194221"),
                    new AnimeSceneImage("https://qph.cf2.quoracdn.net/main-qimg-973980ee97b3b79842d0b0edd0318fdf-lq"),
                    new AnimeSceneImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR1aJMbNkR_aXBpMIdn_1QrRSraaHbi6PPi3g&usqp=CAU"),
                    new AnimeSceneImage("https://myanimefacts.com/wp-content/uploads/2022/09/one-piece-make-you-cry.jpg"),
                    new AnimeSceneImage("https://mangathrill.com/wp-content/uploads/2019/09/weweweewew1280x720.png"),
                    new AnimeSceneImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThzYKqtaMbHJJAukQvVdjCJRTuuC5472mnS7PKDG0ykgpeAEXJHbqrMiuC3gvSsT2Om_w&usqp=CAU"),
                    new AnimeSceneImage("https://3.bp.blogspot.com/-P20fr6yvg5s/Wu6AgGwY5BI/AAAAAAAAciE/6G0vPmbMDeUybiO6kdAGmolTXSIhOl_zwCLcBGAs/s1600/1295cd2f399a2dae1dcf083261d5d6eae4287ed3_hq.jpg"),
                    new AnimeSceneImage("https://static2.srcdn.com/wordpress/wp-content/uploads/2016/08/Brook-from-One-Piece.jpg"),
                    new AnimeSceneImage("https://cdn.myanimelist.net/s/common/uploaded_files/1445961164-5bbabbfe592ddae176ae5417b5662a6a.png"),
                    new AnimeSceneImage("https://qph.cf2.quoracdn.net/main-qimg-ab9dd5ca38bd7cfaa39eece4e4c0118a-lq"),
                    new AnimeSceneImage("https://pbs.twimg.com/media/C03gpV-WQAAqxXf.jpg"),

                //boku no hero
                    new AnimeSceneImage("http://www.heypoorplayer.com/wp-content/uploads/2016/05/MyHeroAcademia8.jpg"),
                    new AnimeSceneImage("https://i.ytimg.com/vi/UQeVkEJ19a4/maxresdefault.jpg"),
                    new AnimeSceneImage("https://static.wikia.nocookie.net/bokunoheroacademia/images/1/1f/Episode_90.png/revision/latest?cb=20210403040340"),
                    new AnimeSceneImage("https://i0.wp.com/100wordanime.blog/wp-content/uploads/2017/09/hero34.jpg?resize=648%2C363&ssl=1"),
                    new AnimeSceneImage("https://i.ytimg.com/vi/oZJ-DTduQsA/maxresdefault.jpg"),

                //haikyuu
                    //new AnimeSceneImage("https://static.wikia.nocookie.net/haikyuu/images/1/14/BokutoKuroo1.png/revision/latest?cb=20151126062054"),
                    //new AnimeSceneImage("https://static.wikia.nocookie.net/haikyuu/images/c/ca/Hinata_VS_Kageyama.PNG/revision/latest/scale-to-width-down/1200?cb=20140407073702"),
                    //new AnimeSceneImage("http://4.bp.blogspot.com/-oK8HepDmGVg/U3bQ50ocYiI/AAAAAAAAAEA/Thk6zF72A8E/s1600/vlcsnap-2014-05-16-22h42m43s186.png"),
                    //new AnimeSceneImage("https://static.wikia.nocookie.net/haikyuu/images/1/14/S4E14.png/revision/latest?cb=20200928112808"),
                    //new AnimeSceneImage("https://static.wikia.nocookie.net/haikyuu/images/b/bc/Direct_Sunlight.png/revision/latest?cb=20151011014107"),

                //kaiji
                    new AnimeSceneImage("https://img1.ak.crunchyroll.com/i/spire2/2ce6fc2b9becf670513d20a59562a6ee1662898642_main.jpg"),
                    new AnimeSceneImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTeTjiZRipU9cgp3rUKM_kUtsU9G9n4g2cuRA&usqp=CAU"),
                    new AnimeSceneImage("https://i.ytimg.com/vi/ThDkgXf3r4g/maxresdefault.jpg"),
                    new AnimeSceneImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSDFogY88A7MkwU2c-hzZgBV70clBVf93dRRw&usqp=CAU"),
                    new AnimeSceneImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQer2jONjY7UxKuRRsWIqeXYAruUhcAm-eXlQ&usqp=CAU"),

                //inazuma eleven
                    new AnimeSceneImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.dailymotion.com%2Fvideo%2Fx7ypnhr&psig=AOvVaw2DuGqpKKMMyo0nwK5F4HPg&ust=1673552212642000&source=images&cd=vfe&ved=0CBAQjRxqFwoTCNim-_uhwPwCFQAAAAAdAAAAABAD"),
                    new AnimeSceneImage("https://i.ytimg.com/vi/A65n3k33IEk/hqdefault.jpg"),
                    new AnimeSceneImage("https://static.tvtropes.org/pmwiki/pub/images/bear_hugs.jpg"),
                    new AnimeSceneImage("https://cdn2.rtva.interactvty.com/content_cards/7b5c890618eb4cd2ad5d57e53a8afa42.jpg"),
                    new AnimeSceneImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQ-xhsP3ZTHAollhV58GXT5n3P3267nwLRASA&usqp=CAU"),

                //aku no hana
                    new AnimeSceneImage("http://farm9.staticflickr.com/8264/8690022356_45cff05bed.jpg"),
                    new AnimeSceneImage("http://blog.draggle.org/wp-content/uploads/2013/06/aku_no_hana_13_2.jpg"),
                    new AnimeSceneImage("http://www.bateszi.me/wp-content/uploads/2013/06/vlcsnap-2013-05-20-20h53m54s234-500x281.png"),
                    new AnimeSceneImage("https://www.themoviedb.org/t/p/w780/l2FjEsiOTEvTZcvW8pDs07X5Q2x.jpg"),
                    new AnimeSceneImage("https://bateszi.me/wp-content/uploads/2013/06/vlcsnap-2013-06-02-13h02m50s188.png"),

                //flcl
                    new AnimeSceneImage("https://i.cdn.turner.com/adultswim/big/img/2018/08/06/flclaltSearch.jpg"),
                    new AnimeSceneImage("https://cdn.vox-cdn.com/thumbor/KK-OXvweM2Y5zzcTVve0RUE6umQ=/0x53:1690x898/fit-in/1200x600/cdn.vox-cdn.com/uploads/chorus_asset/file/11651925/haruka_.jpg"),
                    new AnimeSceneImage("https://i.pinimg.com/originals/63/a5/69/63a5693992b0226916e0b5a26511115a.jpg"),
                    new AnimeSceneImage("https://i.cdn.turner.com/adultswim/big/image-upload/thumbnails/thumb-2_image-15381496590678.jpg"),
                    new AnimeSceneImage("https://m.media-amazon.com/images/M/MV5BYzA2OWYwYzktMDM0ZC00YWQ1LWE3MTUtN2Y3NTY0YmM2ODk5XkEyXkFqcGdeQXVyNjc3OTE4Nzk@._V1_.jpg"),

                //jojo
                    new AnimeSceneImage("https://i.pinimg.com/originals/6c/62/bb/6c62bbe7c4db4f62173a1f60c216671e.jpg"),
                    new AnimeSceneImage("https://occ-0-1007-34.1.nflxso.net/dnm/api/v6/9pS1daC2n6UGc3dUogvWIPMR_OU/AAAABaHDjEjmTA5lhd5xLC5Q33YJ8J71kw2qYLukRMGPeKUzYOFoVCxZGJf1L8lTTwECmHjx2dgmT8-7DCv6ylAto5tPgKnpDG4mJ5FBwLo6zrmiiypbggmiznYA.jpg?r=308"),
                    new AnimeSceneImage("https://img1.ak.crunchyroll.com/i/spire1-tmb/b876abc578c8bf0fab25a4591280cffa1396473017_full.jpg"),
                    new AnimeSceneImage("https://animeuknews.net/app/uploads/2018/04/6-1.png"),
                    new AnimeSceneImage("https://i.ytimg.com/vi/hVIsqLg6nWw/maxresdefault.jpg"),

                //hajime no ippo
                    new AnimeSceneImage("https://www.capsulecomputers.com.au/wp-content/uploads/2013/12/Hajime-No-Ippo-Episode-10-01.jpg"),
                    new AnimeSceneImage("https://static.wikia.nocookie.net/ippo/images/c/c8/The_First_Step.png/revision/latest?cb=20210614123935"),
                    new AnimeSceneImage("https://i.ytimg.com/vi/28UIP1Cgjs4/hqdefault.jpg"),
                    new AnimeSceneImage("https://preview.redd.it/9hbc1te32mp01.png?auto=webp&s=4f424ec1a7a1c5685dcb93421b269f577bcdb49f"),
                    new AnimeSceneImage("https://i.ytimg.com/vi/KJv7w_zz2wU/hqdefault.jpg"),
                    new AnimeSceneImage("https://honeysanime.com/wp-content/uploads/2016/07/6.-hajime-no-ippo-Capture-Season-3-Ep-9-20160731203654-500x280.png"),

                //hero academia
                    new AnimeSceneImage("https://animecorner.me/wp-content/uploads/2021/07/My-Hero-Academia-Preview-Image-Episode-105.jpg"),
                    new AnimeSceneImage("https://www.gamerevolution.com/wp-content/uploads/sites/2/2020/02/My-Hero-Academia-episode-80.jpg"),
                    new AnimeSceneImage("https://i0.wp.com/butwhytho.net/wp-content/uploads/2022/10/My-Hero-Academia-Episode-114-But-Why-Tho.jpg?fit=800%2C410&ssl=1"),
                    new AnimeSceneImage("https://www.gamerevolution.com/wp-content/uploads/sites/2/2022/11/my-hero-academia-season-6-episode-10-release-date-time-crunchyroll-2.jpg?resize=1200,630"),
                    new AnimeSceneImage("https://static.wikia.nocookie.net/bokunoheroacademia/images/9/98/Episode_123.png/revision/latest?cb=20221203170826"),

                //dragon ball
                    new AnimeSceneImage ("https://img4.hulu.com/user/v3/artwork/a1cf1e67-23f7-4d1b-840c-2e3873adfa57?base_image_bucket_name=image_manager&base_image=ace67f72-b95d-4f80-9fe9-e01dbb8d07ba&size=600x338&format=jpeg"),

                //naruto
                    new AnimeSceneImage ("https://staticg.sportskeeda.com/editor/2022/06/c41df-16548411749390-1920.jpg"),
                    new AnimeSceneImage ("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQsY0quNM4kheYhUsrThKYfkdVsPWpDwtkYJA&usqp=CAU"),
                    new AnimeSceneImage ("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0YLKMQjO2Oa259Uap1LA3qtfdmc511DSCI64nN-SfBpgaJmBVxvcegr3tNRI-KV_oD1o&usqp=CAU"),

                //evangelion
                    new AnimeSceneImage ("http://4.bp.blogspot.com/-pa-tKtdQytk/VYonI7m2VLI/AAAAAAAAe34/dPBWME61JlU/s1600/Picture%2B1.png"),
                    new AnimeSceneImage ("https://pictures.betaseries.com/banners/episodes/711/bff55a492756ff611d6b16af6f725160.jpg"),
                    new AnimeSceneImage ("https://static.wikia.nocookie.net/evangelion/images/7/79/Episode_3-_A_Transfer.png/revision/latest?cb=20210717171033"),
                    new AnimeSceneImage ("https://static.wikia.nocookie.net/evangelion/images/9/91/Episode_15.png/revision/latest?cb=20121216053159"),
                    new AnimeSceneImage ("https://filmschoolrejects.com/wp-content/uploads/2019/03/Episode-26_Favorite-Shot-1.jpg")
                    
                    ));
            Collections.shuffle(animeSceneImages);
            animeSceneImageRepository.saveAll(animeSceneImages);
        } catch (Exception e){
            System.out.println("Users exist already in the database");
            System.out.println(e.getMessage());
            System.out.println(e.getCause());
        }


    }

}
