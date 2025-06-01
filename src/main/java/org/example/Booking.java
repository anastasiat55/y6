package org.example;

import java.time.LocalDate;

public class Booking {
    private Long id;
    private Long userId;
    private LocalDate date;
    private String details;

    public Booking() {}
    public Booking(Long id, Long userId, LocalDate date, String details) {
        this.id = id; this.userId = userId; this.date = date; this.details = details;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }

    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }

    public String getDetails() { return details; }
    public void setDetails(String details) { this.details = details; }
}
