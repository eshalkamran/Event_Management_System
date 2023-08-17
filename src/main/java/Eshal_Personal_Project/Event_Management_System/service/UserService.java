package Eshal_Personal_Project.Event_Management_System.service;

import Eshal_Personal_Project.Event_Management_System.model.User;
import Eshal_Personal_Project.Event_Management_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public User updateUser(long id, User updatedUserInfo) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            User userToUpdate = userOptional.get();
            userToUpdate.setEmail(updatedUserInfo.getEmail());
            userToUpdate.setName(updatedUserInfo.getName());
            userToUpdate.setPassword(updatedUserInfo.getPassword());
            return userRepository.save(userToUpdate);
        } else {
            // Handle the case where the user isn't found.
            // You can either return null or throw an exception.
            return null;
        }
    }
}
