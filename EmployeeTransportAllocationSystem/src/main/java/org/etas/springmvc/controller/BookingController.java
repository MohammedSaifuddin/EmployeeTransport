package org.etas.springmvc.controller;

import java.text.ParseException;
import java.util.List;

import org.etas.springmvc.bean.Booking;
import org.etas.springmvc.bean.BookingRequestStatus;
import org.etas.springmvc.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookingController {

    @Autowired
    BookingService bookingService;

    @RequestMapping(value = "/addBooking", method = RequestMethod.POST, headers = "Accept=application/json")
    public ModelAndView addBooking(@ModelAttribute("booking") Booking booking) throws ParseException {
        ModelAndView model = new ModelAndView();
        if (booking.getId() == 0) {
            bookingService.addBooking(booking, model);
        }

        return model;
    }

    @RequestMapping(value = "/cancelBooking/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    public String cancelBooking(@PathVariable("id") int id, Booking booking) {
        ModelAndView model = new ModelAndView();
        bookingService.cancelBooking(booking, id, model);
        return "bookingDetails";
    }

    @RequestMapping(value = "/getAllBookings", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getBookings(Model model) {

        List<Booking> listOfBookings = bookingService.getAllBookings();
        model.addAttribute("booking", new Booking());
        model.addAttribute("listOfBookings", listOfBookings);
        return "bookingDetails";
    }

    @RequestMapping(value = "/getRequestStatusOfBooking", method = RequestMethod.GET, headers = "Accept=application/json")
    public String getRequestStatusOfBooking(Model model) {
        List<BookingRequestStatus> listOfBookings = bookingService.getRequestStatusOfBooking();
        model.addAttribute("bookingrequeststatus", new BookingRequestStatus());
        model.addAttribute("listOfBookingRequestStatus", listOfBookings);
        return "bookingStatusRequest";
    }

}
