package Eshal_Personal_Project.Event_Management_System.dto;

import Eshal_Personal_Project.Event_Management_System.model.Event;
import Eshal_Personal_Project.Event_Management_System.model.User;

import java.util.stream.Collectors;

import java.util.Date;
import java.util.List;

public class EventDTO {
    private Long id;
    private String name;
    private String description;
    private Date date;
    private String location;
    private UserDTO organizer;
    private List<UserDTO> attendees;

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }

    public String getLocation() {
        return location;
    }

    public UserDTO getOrganizer() {
        return organizer;
    }

    public List<UserDTO> getAttendees() {
        return attendees;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setOrganizer(UserDTO organizer) {
        this.organizer = organizer;
    }

    public void setAttendees(List<UserDTO> attendees) {
        this.attendees = attendees;
    }

    public static EventDTO fromModel(Event event) {
        EventDTO dto = new EventDTO();
        dto.setId(event.getId());
        dto.setName(event.getName());
        dto.setDescription(event.getDescription());
        dto.setDate(event.getDate());
        dto.setLocation(event.getLocation());
        dto.setOrganizer(UserDTO.fromModel(event.getOrganizer()));  // Assuming you have fromModel in UserDTO
        dto.setAttendees(event.getAttendees().stream()
                .map(UserDTO::fromModel)
                .collect(Collectors.toList()));  // Convert list of Users to list of UserDTOs
        return dto;
    }

    public Event toModel() {
        Event event = new Event();
        event.setId(this.getId());
        event.setName(this.getName());
        event.setDescription(this.getDescription());
        event.setDate(this.getDate());
        event.setLocation(this.getLocation());
        event.setOrganizer(this.organizer.toModel());  // Assuming you have toModel in UserDTO
        // Convert list of UserDTOs to list of Users
        List<User> eventAttendees = this.attendees.stream()
                .map(UserDTO::toModel)
                .collect(Collectors.toList());
        event.setAttendees(eventAttendees);
        return event;
    }
}