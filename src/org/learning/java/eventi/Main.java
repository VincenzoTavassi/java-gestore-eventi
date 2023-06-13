package org.learning.java.eventi;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Concert concerto = new Concert("Ciao", LocalDate.now().plusDays(20), 200, LocalTime.now().plusHours(4), BigDecimal.valueOf(22.5492));
        Concert concerto2 = new Concert("Bye bye", LocalDate.now().plusDays(2), 100, LocalTime.now().plusHours(4), BigDecimal.valueOf(40.302));
        Event evento1 = new Event("Sai come va?", LocalDate.now().plusDays(2), 300);
        Event evento3 = new Event("tutto bene grazie", LocalDate.now().plusDays(3), 200);

        ProgrammaEventi nuovaLista = new ProgrammaEventi("Lista degli eventi 2023");
        nuovaLista.addEvent(concerto);
        nuovaLista.addEvent(concerto2);
        nuovaLista.addEvent(evento1);
        nuovaLista.addEvent(evento3);
        System.out.println(nuovaLista.listEvents());
        System.out.println(nuovaLista.countEvents());
        nuovaLista.resetEvents();
        nuovaLista.countEvents();


        System.out.println(concerto.getFormattedPrice());
        System.out.println(concerto.getFormattedDate());
        System.out.println(concerto);

        System.out.println("Benvenuto. Inserisci il titolo di un nuovo evento");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        boolean valid = false;
        LocalDate date = null;
        Event event = null;
        while(!valid) {
            System.out.println("Inserisci la data dell'evento nel formato dd/mm/yyyy");
            String rawDate = scanner.nextLine();
            try {
        date = Event.createDate(rawDate);
        if(Event.isInvalidDate(date)) throw new RuntimeException();
        else valid = true;
        } catch(RuntimeException e) {
            System.out.println("Data non valida");
        }
        }

        valid = false;

        while(!valid) {
        System.out.println("Inserisci la capienza massima dell'evento");
        int maxSeats = 0;
        try {
            maxSeats = Integer.parseInt(scanner.nextLine());
            event = new Event(title, date, maxSeats);
            valid = true;
        } catch (NumberFormatException e) {
            System.out.println("Il numero inserito non è valido");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        }

        valid = false;

        System.out.println(event);

        while(!valid) {
        System.out.println("Quanti posti vuoi prenotare?");
        try {
        int numberTobook = Integer.parseInt(scanner.nextLine());
        event.book(numberTobook);
        valid = true;
        } catch (NumberFormatException e) {
            System.out.println("Il numero inserito non è valido");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        }

        System.out.println("Adesso ci sono " + event.getBookedSeats() + " posti prenotati, su una capienza di " + event.getMaxSeats() + " posti.");
        System.out.println("Posti disponibili: " + (event.getMaxSeats() - event.getBookedSeats()));

        valid = false;
        while(!valid) {
        System.out.println("Quanti posti vuoi disdire?");
        int numberToCancel = Integer.parseInt(scanner.nextLine());
        try {
        event.cancel(numberToCancel);
        valid = true;
        }
        catch (RuntimeException e) {
            System.out.println("Il numero inserito non è valido");
        } }

        System.out.println("Adesso ci sono " + event.getBookedSeats() + " posti prenotati, su una capienza di " + event.getMaxSeats() + " posti.");
        System.out.println("Posti disponibili: " + (event.getMaxSeats() - event.getBookedSeats()));
    }

}