package org.etas.springmvc.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.etas.springmvc.bean.Booking;
import org.etas.springmvc.bean.BookingRequestStatus;
import org.etas.springmvc.dao.BookingDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.ModelAndView;

@Service("bookingService")
public class BookingService {

    @Autowired
    BookingDAO bookingDAO;

    @Transactional
    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }

    @Transactional
    public Booking getBooking(int id) {
        return bookingDAO.getBooking(id);
    }

    @Transactional
    public void addBooking(Booking booking, ModelAndView model) throws ParseException {
        String bookingStatus = null;
        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());

        // create a calendar and assign it the same time
        Calendar bookingTimeDetail = Calendar.getInstance();
        bookingTimeDetail.setTimeInMillis(booking.getDateTimeOfJourney().getTime());

        // add a bunch of seconds to the calendar
        bookingTimeDetail.add(Calendar.SECOND, 98765);
        long milliseconds = booking.getDateTimeOfJourney().getTime() - currentTimestamp.getTime();
        int seconds = (int) milliseconds / 1000;

        // calculate hours minutes and seconds
        int BookingHours = seconds / 3600;
        seconds = (seconds % 3600) % 60;
        int bookingDay = booking.getDateTimeOfJourney().getDay();

        Date date = new Date(booking.getDateTimeOfJourney().getTime());

        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String formattedBokingTime = formatter.format(date);

        if (booking.getDateTimeOfJourney().after(currentTimestamp)) {

            if (BookingHours > 12 && BookingHours < 48) {
                if (bookingDay >= 1 && bookingDay <= 5) {
                    String timeComparisionFrom10pm = "22:00:00";
                    Date time10pm = new SimpleDateFormat("HH:mm:ss").parse(timeComparisionFrom10pm);
                    Calendar timeCompareDay1_10pm = Calendar.getInstance();
                    timeCompareDay1_10pm.setTime(time10pm);

                    String timeComparisionupto12am = "23:59:59";
                    Date timeTo12am = new SimpleDateFormat("HH:mm:ss").parse(timeComparisionupto12am);
                    Calendar timeCompareUpto_12am = Calendar.getInstance();
                    timeCompareUpto_12am.setTime(timeTo12am);
                    // calendar2.add(Calendar.DATE, 1);

                    String timeComparisionFrom12am = "00:00:00";
                    Date timefrom12am = new SimpleDateFormat("HH:mm:ss").parse(timeComparisionFrom12am);
                    Calendar timeCompare_from12am = Calendar.getInstance();
                    timeCompare_from12am.setTime(timefrom12am);

                    String timeComparisionUpto1am = "01:00:00";
                    Date timeUpto1am = new SimpleDateFormat("HH:mm:ss").parse(timeComparisionUpto1am);
                    Calendar timeCompare_upto1am = Calendar.getInstance();
                    timeCompare_upto1am.setTime(timeUpto1am);

                    Date dateForBookingTime = new SimpleDateFormat("HH:mm:ss").parse(formattedBokingTime);
                    Calendar calendar = Calendar.getInstance();
                    calendar.setTime(dateForBookingTime);

                    Date bookingTime = calendar.getTime();
                    if (((bookingTime.after(timeCompareDay1_10pm.getTime())) && (bookingTime.before(timeCompareUpto_12am.getTime())))
                            || ((bookingTime.after(timeCompare_from12am.getTime()))
                                    && (bookingTime.before(timeCompare_upto1am.getTime())))) {

                        bookingDAO.addBooking(booking);

                        bookingStatus = "Request Id is " + Integer.toString(booking.getId());

                        model.addObject("ERROR_CODE", bookingStatus);
                        model.setViewName("bookingDetails");
                        System.out.println("Cab Booked");
                    } else {
                        bookingStatus = "CAB_NOT_AVAILABLE";
                        model.addObject("ERROR_CODE", bookingStatus);
                        model.setViewName("bookingDetails");
                    }

                } else {
                    bookingStatus = "CAB_NOT_AVAILABLE_ON_WEEKEND";
                    model.addObject("ERROR_CODE", bookingStatus);
                    model.setViewName("bookingDetails");

                }
            } else if (BookingHours >= 3 && BookingHours <= 12) {

                bookingStatus = "REQUEST_NOT_POSSIBLE";

                System.out.println("cab cannot be booked between 3 to 12 hours before journey");

                model.addObject("ERROR_CODE", bookingStatus);
                model.setViewName("bookingDetails");

            } else {
                bookingStatus = "INVALID_TRIP_TIME";

                System.out.println("cab cannot be booked between 3 to 12 hours before journey");

                model.addObject("ERROR_CODE", bookingStatus);
                model.setViewName("bookingDetails");
            }
        } else {
            bookingStatus = "BOOKING_TIME_EXPIRED";

            System.out.println("cab cannot be booked before the current time");

            model.addObject("ERROR_CODE", bookingStatus);
            model.setViewName("bookingDetails");
        }
    }

    @Transactional
    public void cancelBooking(Booking booking, int id, ModelAndView model) {
        String bookingStatus = null;
        bookingStatus = "DELETED--" + id;
        model.addObject("ERROR_CODE", bookingStatus);
        Object bookinTime = bookingDAO.getBookingTime(booking, model, id);
        String text = "2015-05-28 12:45:59";
        Timestamp timestamp = Timestamp.valueOf(bookinTime.toString());

        Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
        // create a calendar and assign it the same time
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(timestamp.getTime());

        // add a bunch of seconds to the calendar
        cal.add(Calendar.SECOND, 98765);
        long milliseconds = timestamp.getTime() - currentTimestamp.getTime();
        int seconds = (int) milliseconds / 1000;
        System.out.println("SECOND" + seconds);
        if (seconds < 10800) {
            bookingStatus = "Booking Cannot Be cancelled within 3 hours from journey for Id -" + id;
            model.addObject("ERROR_CODE", bookingStatus);
            model.setViewName("bookingDetails");
        } else {
            System.out.println("-------Bookingtimeis----" + bookinTime);
            bookingDAO.cancelBooking(booking, id, model);
            model.setViewName("bookingDetails");
        }
    }

    @Transactional
    public List<BookingRequestStatus> getRequestStatusOfBooking() {
        return bookingDAO.getRequestStatusOfBooking();
    }

}
