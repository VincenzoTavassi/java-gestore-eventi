package org.learning.java.eventi;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Event {

    private String title;
    private LocalDate date;
    private final int MAX_SEATS;

    private int bookedSeats;


// CONSTRUCTOR
    public Event(String title, LocalDate date, int MAX_SEATS) throws EventException {
        if (title.isBlank() || title.length() < 1) throw new EventException("Title must not be blank");
        else this.title = title;
        if (!isInvalidDate(date)) this.date = date;
        else throw new EventException("Event date must be a future date");
        if (MAX_SEATS < 1) throw new EventException("Available seats must be more than one");
        else this.MAX_SEATS = MAX_SEATS;
        this.bookedSeats = 0;
    }

    // GETTERS -SETTERS
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) throws EventException {
        if (title.isBlank() || title.length() < 1) throw new EventException("Title must not be blank");
        else this.title = title;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) throws EventException {
        if (isInvalidDate(date)) throw new EventException("Event date must be a future date");
        else this.date = date;
    }

    public int getMaxSeats() {
        return MAX_SEATS;
    }

    public int getBookedSeats() {
        return bookedSeats;
    }

    // CHECK/CONTROL METHODS
    public static boolean isInvalidDate(LocalDate date) {
        return date.isBefore(LocalDate.now());
    }

    public boolean isInvalidEvent() {
        return isInvalidDate(date) || !HasAvailableSeats();
    }

    public boolean HasAvailableSeats() {
        return MAX_SEATS > bookedSeats;
    }

    // TO STRING OVERRIDE
    @Override
    public String toString() {
        return "Evento: " + formatDate(date) + " -" + " " + title;
    }

    // EVENT BOOKING METHODS

    public boolean book() throws EventException {
        boolean success;
        if (isInvalidDate(date)) throw new EventException("You are trying to book for a past event");
        else if (!HasAvailableSeats()) throw new EventException("The event is full");
        else {
            bookedSeats++;
            success = true;
        }
            return success;
    }

    public boolean book(int number) throws EventException {
        boolean success;
        if (isInvalidDate(date)) throw new EventException("You are trying to book for a past event");
        else if (bookedSeats + number > MAX_SEATS) throw new EventException("You are trying to book more than available seats");
        else {
            bookedSeats += number;
            success = true;
        }
        return success;
    }

    public boolean cancel() throws EventException {
        boolean success;
        if (isInvalidDate(date)) throw new EventException("You are trying to cancel for a past event");
        else if (bookedSeats < 1) throw new EventException("There are no booked seats to cancel");
        else {
            bookedSeats--;
            success = true;
        }
        return success;
    }

    public boolean cancel(int number) throws EventException {
        boolean success;
        if (isInvalidDate(date)) throw new EventException("You are trying to cancel for a past event");
        else if (bookedSeats - number < 0) throw new EventException("Not enough bookings to cancel");
        else {
            bookedSeats -= number;
            success = true;
        }
        return success;
    }

    // CREATE DATE METHOD
    public static LocalDate createDate(String date) {
//        String[] dateElements = date.split("/");
//        int day = Integer.parseInt(dateElements[0]);
//        int month = Integer.parseInt(dateElements[1]);
//        int year = Integer.parseInt((dateElements[2]));
//        return LocalDate.of(year, month, day);
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public static String formatDate (LocalDate date) {
        return date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
