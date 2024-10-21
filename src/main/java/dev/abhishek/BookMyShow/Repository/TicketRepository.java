package dev.abhishek.BookMyShow.Repository;

import dev.abhishek.BookMyShow.Models.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<Ticket ,Integer> {
}
