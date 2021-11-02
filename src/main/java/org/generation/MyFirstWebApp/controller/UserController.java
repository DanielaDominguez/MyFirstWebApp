package org.generation.MyFirstWebApp.controller;

import org.generation.MyFirstWebApp.model.User;
import org.generation.MyFirstWebApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController
{
    final UserService userService;

    public UserController( @Autowired UserService userService )
    {
        this.userService = userService;
        userService.add( new User( 1, "Mauricio", "DP" ) );
        userService.add( new User( 2, "Daniela", "DP" ) );
        userService.add( new User( 3, "Angie", "PE" ) );

    }

    @GetMapping( "/user" )
    public User getUser() { return userService.getUser( 0 ); }

    @GetMapping("/users/all")
    public int totalUsers(){
        return userService.size();
    }
    @GetMapping("user/all_users")
    public List<User> getAll()
    {
        return userService.getAll();
    }
}
