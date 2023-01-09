package com.ironhack.otakuhub.controller;

import com.ironhack.otakuhub.dto.UserDTO;
import com.ironhack.otakuhub.enums.Level;
import com.ironhack.otakuhub.model.Anime;
import com.ironhack.otakuhub.model.Quote;
import com.ironhack.otakuhub.model.User;
import com.ironhack.otakuhub.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

/**
* Listar todos los usuarios de la base de datos
*/
    @GetMapping
    public List<User> getAllUsers () {
        return userService.findAll();
    }

    @PostMapping("/create")
    @ResponseStatus (HttpStatus.CREATED)
    public User createUser (@RequestBody UserDTO userDTO) {
        return userService.createUser (userDTO);
    }

    /**
    Borrar usuario: accesible por usuario y admin
     */
    @DeleteMapping("/delete/{username}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public List<User> deleteUser (@PathVariable ("username") String username) {
        return userService.deleteUserByUsername(username);
    }

    /**
    updateUSerByAdmin puede modificar todos los campos del objeto usuario
    Este método solo es accesible por el administrador
     */
    @PatchMapping("admin/updateUser/{username}")
    public User updateUserByAdmin (@PathVariable String username,
                                    @RequestParam Optional <String> username1,
                                    @RequestParam Optional <String> password,
                                    @RequestParam Optional <String> roles,
                                    @RequestParam Optional <Boolean> isAccountNonLocked,
                                    @RequestParam Optional <Integer> points,
                                    @RequestParam Optional <Level> level,
                                    @RequestParam Optional <Anime> anime,
                                    @RequestParam Optional <Quote> animeQuote){
        return userService.updateUserByAdmin (username,username1, password, roles, isAccountNonLocked, points, level, anime, animeQuote);
    }

    /**
    updateUserByUser: solo actualiza el username y el password
    endpoint accesible por el usuario
     */
    @PatchMapping("updateByUser/{username}")
    public User updateUserByUser (@PathVariable String username,
                                   @RequestParam Optional<String> username1,
                                   @RequestParam Optional <String> password,
                                   @RequestParam Optional <Anime> anime
                                   ){
        return userService.updateUserByUser (username, username1,password,anime);
    }

    @PatchMapping("/addpoints/{username}")
    public User addPoints (@PathVariable String username){
        return userService.addPoints(username);
    }

    /**
    comprobación si el usuario está en la base de datos: a partir del username
     */
    @GetMapping ("checkuser/{username}")
    public Boolean userExist (String username) {
        return userService.userExist (username);
    }








}