package Eshal_Personal_Project.Event_Management_System.repository;
import Eshal_Personal_Project.Event_Management_System.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
