package Eshal_Personal_Project.Event_Management_System.repository;
import Eshal_Personal_Project.Event_Management_System.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}
