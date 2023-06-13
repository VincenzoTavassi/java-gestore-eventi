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


    public Concert(String title, LocalDate date, int MAX_SEATS, LocalTime hour, BigDecimal price) {
        super(title, date, MAX_SEATS);
        this.hour = hour;
        this.price = price;
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFormattedPrice() {
        DecimalFormat formatter = new DecimalFormat("€ ##.##");
        return formatter.format(price);
    }

    public String getFormattedDate() {
        LocalDate date = super.getDate();
        LocalDateTime fulldate = LocalDateTime.parse(String.valueOf(date) + "T" + String.valueOf(hour));
        return fulldate.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).withLocale(Locale.ITALY));
    }

    @Override
    public String toString() {
        return "Concerto del " + getFormattedDate() + " - " + super.getTitle() + " - " + getFormattedPrice();
    }
}
