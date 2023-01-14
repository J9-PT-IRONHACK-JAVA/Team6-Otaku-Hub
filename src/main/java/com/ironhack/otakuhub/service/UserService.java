package com.ironhack.otakuhub.service;

import com.ironhack.otakuhub.dto.AnimeDTO;
import com.ironhack.otakuhub.dto.UserDTO;
import com.ironhack.otakuhub.enums.Level;
import com.ironhack.otakuhub.exception.UsernameNotFoundException;
import com.ironhack.otakuhub.model.Anime;
import com.ironhack.otakuhub.model.Episode;
import com.ironhack.otakuhub.model.Quote;
import com.ironhack.otakuhub.model.User;
import com.ironhack.otakuhub.proxy.AnimeProxy;
import com.ironhack.otakuhub.repository.AnimeRepository;
import com.ironhack.otakuhub.repository.EpisodeRepository;
import com.ironhack.otakuhub.repository.UserRepository;
import com.ironhack.otakuhub.exception.UserNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.ironhack.otakuhub.enums.Level.NOOB;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AnimeProxy animeProxy;
    private final AnimeRepository animeRepository;
    private final EpisodeRepository episodeRepository;


    public User createUser(UserDTO userDTO) {
        var user = new User ();
        user.setPassword(passwordEncoder.encode(userDTO.getPassword()));
        user.setUsername(userDTO.getUsername());
        user.setRoles("ROLE_USER");
        user.setPoints(0);
        user.setLevel(Level.NOOB);
        return userRepository.save(user);

    }

    public void deleteUserByUsername(String username) {

        var user = findUserByUsername (username);
        userRepository.delete(user);
        //return userRepository.deleteUserByUsername(username);
    }

    public User updateUserByAdmin ( String username, //as id
                                    Optional <String> username1, //username = username1
                                    Optional<String> password,
                                    Optional<String> roles,
                                    Optional<Boolean> isAccountNonLocked,
                                    Optional<Integer> points,
                                    Optional<Level> level,
                                    Optional<Anime> anime,
                                    Optional<Quote> animeQuote) {

        var userToUpdate = findUserByUsername (username);

        username1.ifPresent (userToUpdate::setUsername);

        if (password.isPresent()) {
            userToUpdate.setPassword(passwordEncoder.encode(password.orElseThrow()));
        }

       // password.ifPresent(userToUpdate::passwordEncoder.encode(password));

        roles.ifPresent(userToUpdate::setRoles);
        isAccountNonLocked.ifPresent(userToUpdate::setIsAccountNonLocked);
        points.ifPresent(userToUpdate::setPoints);
        level.ifPresent(userToUpdate::setLevel);
        anime.ifPresent(userToUpdate::addAnimeToAnimeList);
        animeQuote.ifPresent(userToUpdate::addQuoteToQuoteList);

        return userRepository.save(userToUpdate);
    }

    private User findUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
    }

    private User findUserById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    public User updateUserByUser(String username, Optional <String> username1, Optional<String> password) {

        var userToUpdate = findUserByUsername (username);

        username1.ifPresent(userToUpdate::setUsername);
        password.ifPresent(userToUpdate::setPassword);

        return userRepository.save(userToUpdate);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User addPoints(String username) {
            var userToAddPoints = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
            userToAddPoints.addPoints();

        return userRepository.save (userToAddPoints);
    }

    public Boolean userExist(String username) {
        var userToCheck = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException(username));
        if (userToCheck != null) {
            return true;
        }
        else {
            return false;
        }
    }

    public User addAnimeToUser(String username, String animeId) {
        var userToUpdate = findUserByUsername(username);
        var animeDTO = new AnimeDTO ();
        animeDTO = animeProxy.getAnimeDetails(animeId);

        var animeToAdd = new Anime ();

        //Traducción de animeDTO --> Anime
        animeToAdd.setAnimeId(animeDTO.getAnimeTitle());
        animeToAdd.setAnimeTitle(animeDTO.getAnimeTitle());
        animeToAdd.setAnimeImg(animeDTO.getAnimeImg());
        animeToAdd.setStatus(animeDTO.getStatus());
        animeToAdd.setType(animeDTO.getType());
        animeToAdd.setReleasedDate(animeDTO.getReleasedDate());
        animeToAdd.setGenres(animeDTO.getGenres());
        //animeToAdd.setSynopsis(animeDTO.getSynopsis());
        animeToAdd.setTotalEpisodes(animeDTO.getTotalEpisodes());
        //animeToAdd.setEpisodesList(animeDTO.getEpisodesList());
        //animeToAdd.setUsers(animeDTO.getUsers());

        boolean animeIsOnTheList = false;

        //Compruebo si el anime está en la lista de favoritos del usuario
        for ( Anime anime:userToUpdate.getAnimeList()) {
            if (anime.getAnimeTitle().equals(animeToAdd.getAnimeTitle())) {
                animeIsOnTheList = true;
            }
        }

        //Si el anime no está en la lista, se añade a la lista del usuario
        if (!animeIsOnTheList) {
           // episodeRepository.saveAll(animeToAdd.getEpisodesList());

            if  (!animeRepository.existsById(animeToAdd.getAnimeId())) {
                animeToAdd = animeRepository.save (animeToAdd);
            }
           if(!animeToAdd.getAnimeTitle().isEmpty()){
            userToUpdate.addAnimeToAnimeList(animeToAdd);
            };
        }
        return userRepository.save(userToUpdate);
        }


    public User getUser(String username) {
        return userRepository.findByUsername(username).get();
    }
}
