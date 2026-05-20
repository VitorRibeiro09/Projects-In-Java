package br.com.fatec.weather;

import java.time.LocalDate;

public class PrecipitationRecord {
    private LocalDate date;
    private double amount;

    public PrecipitationRecord(LocalDate date, double amount) {
        this.date = date;
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return date + " -> " + amount + " mm";
    }
}
