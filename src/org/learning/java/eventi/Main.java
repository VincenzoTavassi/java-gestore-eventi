package org.learning.java.eventi;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        Event evento = new Event("Nuovo evento", today, 500);

        System.out.println(evento.getDate());
        System.out.println(evento.book());
        System.out.println(evento.getBookedSeats());
        System.out.println(evento.book());
        System.out.println(evento.getBookedSeats());
        System.out.println(evento.cancel());
        System.out.println(evento.getBookedSeats());
        evento.cancel();

        Event evento2 = new Event("Un altro evento", today.minusDays(1), 2);
        evento2.cancel();

    }
}