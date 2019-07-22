package org.etas.springmvc.dao;

import java.util.List;

import org.etas.springmvc.bean.Booking;
import org.etas.springmvc.bean.BookingRequestStatus;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.ModelAndView;

@Repository
public class BookingDAO {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

    public List<Booking> getAllBookings() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Booking> bookingList = session.createQuery("from Booking").list();
        return bookingList;
    }

    public Booking getBooking(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Booking booking = (Booking) session.load(Booking.class, new Integer(id));
        return booking;
    }

    public Booking addBooking(Booking booking) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(booking);
        return booking;
    }

    public void cancelBooking(Booking booking, int id, ModelAndView model) {
        Session session = this.sessionFactory.getCurrentSession();
        Query qry = session.createQuery(" update Booking set bookingStatusOfJourney = 0 where id= " + id);
        model.setViewName("bookingDetails");
        qry.executeUpdate();
    }

    public Object getBookingTime(Booking booking, ModelAndView model, int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Query qry = session.createQuery("select dateTimeOfJoursney from Booking where id= " + id);
        return qry.uniqueResult();
    }

    public List<BookingRequestStatus> getRequestStatusOfBooking() {
        Session session = this.sessionFactory.getCurrentSession();
        // requestId requestStatus comments bookingId sourceLocation
        // dateTimeOfJourney requestCreationDate requestGenerator
        List<BookingRequestStatus> listOFRequestStatus = session
                .createQuery(
                        "select b.id, b.bookingStatusOfJourney, c.comments , b.sourceLocation , b.dateTimeOfJourney from Booking b, Cab c ")
                .list();
        System.out.println("========QUERY FOR REQUEST STATUS-----" + listOFRequestStatus.toString());
        return listOFRequestStatus;
    }
}
