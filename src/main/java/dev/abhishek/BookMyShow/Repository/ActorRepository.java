package dev.abhishek.BookMyShow.Repository;

import dev.abhishek.BookMyShow.Models.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepository extends JpaRepository<Actor,Integer> {
}
