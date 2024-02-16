package ru.example.hometask_spring_testing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.example.hometask_spring_testing.entities.Session;

@Repository
public interface SessionRepository extends JpaRepository<Session, Long> {
}
