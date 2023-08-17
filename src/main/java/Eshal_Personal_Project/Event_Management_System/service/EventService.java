package Eshal_Personal_Project.Event_Management_System.service;
import Eshal_Personal_Project.Event_Management_System.model.Event;
import Eshal_Personal_Project.Event_Management_System.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id).orElse(null);
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

    public Event addEvent(Event newEvent) {
        return eventRepository.save(newEvent);
    }

}
