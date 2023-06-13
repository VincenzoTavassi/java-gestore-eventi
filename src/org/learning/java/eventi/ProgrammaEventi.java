package org.learning.java.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {

    private String title;
    private List<Event> eventList;

    public ProgrammaEventi(String title) {
        if (!title.isBlank() && title.length() > 0) this.title = title;
        else throw new RuntimeException("Il titolo deve essere valorizzato");
        this.eventList = new ArrayList<>();
    }

    public void addEvent (Event event) {
        eventList.add(event);
    }

    public List<Event> listEventsByDate(String userDate) {
        LocalDate date = Event.createDate(userDate);
        List<Event> filteredList = new ArrayList<>();
        for (Event event : eventList) {
            if (event.getDate().isEqual(date)) filteredList.add(event);
        }
        return filteredList;
    }

    public List<Event> listEventsByDate(LocalDate userDate) {
        List<Event> filteredList = new ArrayList<>();
        for (Event event : eventList) {
            if (event.getDate().isEqual(userDate)) filteredList.add(event);
        }
        return filteredList;
    }

    public int countEvents() {
        if (eventList != null) return eventList.size();
        else throw new NullPointerException();
    }

    public void resetEvents() {
        eventList.clear();
    }

    public String listEvents() {
        String list = "";
    for (Event event : eventList) {
        if (event instanceof Concert) list += Event.formatDate(event.getDate()) + " - " + event.getTitle() + " (Concerto)" + "\n";
        else list += Event.formatDate(event.getDate()) + " - " + event.getTitle() + "\n";
    }
    return list;
    }
}
