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
        return eventList.size();
    }

    public void resetEvents() {
        eventList = null;
    }

    public String listEvents() {
        String list = null;
    for (Event event : eventList) {
        list += event.getDate() + " - " + event.getTitle() + "\n";
    }
    return list;
    }
}
