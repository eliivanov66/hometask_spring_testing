package ru.example.hometask_spring_testing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.example.hometask_spring_testing.entities.Session;
import ru.example.hometask_spring_testing.repositories.SessionRepository;
import ru.example.hometask_spring_testing.entities.User;
import ru.example.hometask_spring_testing.repositories.UserRepository;

import java.util.List;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final SessionRepository sessionRepository;
    @Autowired
    public AuthService(UserRepository userRepository, SessionRepository sessionRepository) {
        this.userRepository = userRepository;
        this.sessionRepository = sessionRepository;
    }
    public Session login(String username, String password){
        User userFound = userRepository.findUserByName(username.toLowerCase());
        if (userFound != null) {
            if (userFound.getPassword().equals(password)){
                if (! sessionRepository.findAll().stream().map(t -> t.getLoggedUser().getName()).toList().contains(userFound.getName())) {
                    return sessionRepository.save(new Session(userFound));
                }
            }
        }
        return null;
    }

    public User register(User user){
        if (! userRepository.findAll().stream().map(t -> t.getName()).toList().contains(user.getName())){
            userRepository.save(user);
        }
        return null;
    }
    public Session logout(Long id){
        if (sessionRepository.findAll().stream().map(t -> t.getLoggedUser().getId()).toList().contains(id)){
            Session sessionFound = sessionRepository.findAll().stream().filter(t -> t.getLoggedUser().getId().equals(id)).findFirst().get();
            sessionRepository.delete(sessionFound);
            return sessionFound;
        }
        return null;
    }
    public List<Session> getSessions(){
        return sessionRepository.findAll();
    }
    public List<User> getUsers(){
        return userRepository.findAll();
    }

}
