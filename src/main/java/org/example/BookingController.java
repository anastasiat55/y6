package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @GetMapping("/bookings")
    public String bookingsPage(Model model) {
        model.addAttribute("bookings", bookingService.getAllBookings());
        model.addAttribute("newBooking", new Booking());
        return "bookings";
    }

    @PostMapping("/bookings/add")
    public String addBooking(@ModelAttribute("newBooking") Booking booking) {
        bookingService.saveBooking(booking);
        return "redirect:/bookings";
    }

    @PostMapping("/bookings/delete")
    public String deleteBooking(@RequestParam("id") Long id) {
        bookingService.deleteBooking(id);
        return "redirect:/bookings";
    }
}
