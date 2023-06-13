package org.learning.java.eventi;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class Concert extends Event {
    private LocalTime hour;
    private BigDecimal price;


    public Concert(String title, LocalDate date, int MAX_SEATS, LocalTime hour, BigDecimal price) throws EventException {
        super(title, date, MAX_SEATS);
        try {
        this.hour = hour;
        if(price.compareTo(BigDecimal.valueOf(0)) > 0) this.price = price;
        else throw new EventException("Il prezzo deve essere un numero positivo");
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public LocalTime getHour() {
        return hour;
    }

    public void setHour(LocalTime hour) {
        this.hour = hour;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) throws EventException {
        if(price.compareTo(BigDecimal.valueOf(0)) > 0) this.price = price;
        else throw new EventException("Il prezzo deve essere un numero positivo");
    }

    public String getFormattedPrice() {
        DecimalFormat formatter = new DecimalFormat("€ ##.##");
        return formatter.format(price);
    }

    public String getFormattedDate() {
        LocalDate date = super.getDate();
        LocalDateTime fulldate = LocalDateTime.parse(date + "T" + hour);
        String fulldateFormat = fulldate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.ITALY));
        String[] fulldateElements = fulldateFormat.split(",");
        return fulldateElements[0] + " alle" + fulldateElements[1];
    }

    @Override
    public String toString() {
        return "Concerto del " + getFormattedDate() + " - " + super.getTitle() + " - " + getFormattedPrice();
    }
}
