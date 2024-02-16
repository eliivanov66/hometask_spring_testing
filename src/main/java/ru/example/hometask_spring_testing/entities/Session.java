package ru.example.hometask_spring_testing.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "sessions")
public class Session {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    User loggedUser;

    @Autowired
    public Session(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    @Autowired
    public Session() {
        this.loggedUser = new User();
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }


    @Override
    public String toString() {
        return "Session{" +
                "loggedUser=" + loggedUser +
                '}';
    }
}
