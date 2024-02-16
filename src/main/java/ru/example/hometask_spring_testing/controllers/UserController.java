package ru.example.hometask_spring_testing.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.example.hometask_spring_testing.entities.Session;
import ru.example.hometask_spring_testing.entities.User;
import ru.example.hometask_spring_testing.services.AuthService;

import java.util.List;

@RestController
@RequestMapping
public class UserController {
    private final AuthService authService;
    @Autowired
    public UserController(AuthService authService) {
        this.authService = authService;
    }
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String info(){
        return "================== AuthService ======================\n" +
                "help:" +
                "\n   use POST /api/login + RequestParam('name') + RequestParam('password') for login" +
                "\n   use POST /api/register + RequestParam('name') + RequestParam('password') for registration" +
                "\n   use UPDATE /api/logout + RequestParam('id') for logout session with id" +
                "\n   use GET /api/sessions to get all current logged sessions" +
                "=====================================================";
    }


    @RequestMapping(value = "/api/sessions", method = RequestMethod.GET)
    public List<Session> getSessions(){
        return authService.getSessions();
    }

    @RequestMapping(value = "/api/users", method = RequestMethod.GET)
    public List<User> getUsers(){
        return authService.getUsers();
    }
    @RequestMapping(value = "/api/login", method = RequestMethod.GET)
    public Session login(@RequestParam("name") String userName, @RequestParam("password") String password){
        return authService.login(userName, password);
    }

    @RequestMapping(value = "/api/register", method = RequestMethod.GET)
    public User register(@RequestParam("name") String userName, @RequestParam("password") String password){
        return authService.register(new User(userName, password));
    }

    @RequestMapping(value = "/api/logout", method = RequestMethod.GET)
    public Session logout(@RequestParam("id") Long id){
        return authService.logout(id);
    }

}
