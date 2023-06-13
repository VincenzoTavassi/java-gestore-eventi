package org.learning.java.eventi;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Benvenuto. Inserisci il titolo di un nuovo evento");
        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();
        System.out.println("Inserisci la data dell'evento nel formato dd/mm/yyyy");
        String rawDate = scanner.nextLine();
        LocalDate date = null;
        Event event = null;
        try {
        date = Event.createDate(rawDate);
        } catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Inserisci la capienza massima dell'evento");
        int maxSeats = 0;
        try {
            maxSeats = Integer.parseInt(scanner.nextLine());
            event = new Event(title, date, maxSeats);
        } catch (NumberFormatException e) {
            System.out.println("Il numero inserito non è valido");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(event);
        System.out.println("Quanti posti vuoi prenotare?");
        try {
        int numberTobook = Integer.parseInt(scanner.nextLine());
        event.book(numberTobook);
        } catch (NumberFormatException e) {
            System.out.println("Il numero inserito non è valido");
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Adesso ci sono " + event.getBookedSeats() + " posti prenotati, su una capienza di " + event.getMaxSeats() + " posti.");
        System.out.println("Posti disponibili: " + (event.getMaxSeats() - event.getBookedSeats()));
        System.out.println("Quanti posti vuoi disdire?");
        int numberToCancel = Integer.parseInt(scanner.nextLine());
        try {
        event.cancel(numberToCancel);
        }
        catch (RuntimeException e) {
            System.out.println("Il numero inserito non è valido");
        }
        System.out.println("Adesso ci sono " + event.getBookedSeats() + " posti prenotati, su una capienza di " + event.getMaxSeats() + " posti.");
        System.out.println("Posti disponibili: " + (event.getMaxSeats() - event.getBookedSeats()));
    }

}