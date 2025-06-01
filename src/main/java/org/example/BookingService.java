package org.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
class UserService {
    private List<User> users = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    public List<User> getAllUsers() {
        return users;
    }

    public void saveUser(User user) {
        if (user.getId() == null) {
            user.setId(idCounter.incrementAndGet());
            users.add(user);
        } else {
            users.removeIf(u -> u.getId().equals(user.getId()));
            users.add(user);
        }
    }

    public void deleteUser(Long id) {
        users.removeIf(u -> u.getId().equals(id));
    }
}

@Service
public class BookingService {
    private List<Booking> bookings = new ArrayList<>();
    private AtomicLong idCounter = new AtomicLong();

    public List<Booking> getAllBookings() {
        return bookings;
    }

    public void saveBooking(Booking booking) {
        if (booking.getId() == null) {
            booking.setId(idCounter.incrementAndGet());
            bookings.add(booking);
        } else {
            bookings.removeIf(b -> b.getId().equals(booking.getId()));
            bookings.add(booking);
        }
    }

    public void deleteBooking(Long id) {
        bookings.removeIf(b -> b.getId().equals(id));
    }
}
