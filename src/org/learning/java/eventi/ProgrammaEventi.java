package org.learning.java.eventi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProgrammaEventi {

    private String title;
    private List<Event> eventList;

    public ProgrammaEventi(String title) {
        this.title = title;
        this.eventList = new ArrayList<>();
    }

    public void addEvent (Event event) {
        eventList.add(event);
    }

    public List<Event> listEventsByDate(LocalDate date) {
        List<Event> filteredList = null;
        for (Event event : eventList) {
            if (event.getDate() == date) filteredList.add(event);
        }
        return filteredList;
    }

    public int countEvents() {
        if (eventList != null) return eventList.size();
        else throw new NullPointerException();
    }

    public void resetEvents() {
        eventList.removeAll(eventList);
    }

    public String listEvents() {
        String list = "";
    for (Event event : eventList) {
        if (event instanceof Concert) list += event.getDate() + " - " + event.getTitle() + " (Concerto)" + "\n";
        else list += event.getDate() + " - " + event.getTitle() + "\n";
    }
    return list;
    }
}
