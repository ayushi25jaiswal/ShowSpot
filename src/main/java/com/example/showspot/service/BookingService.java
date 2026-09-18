package com.example.showspot.service;

import com.example.showspot.exceptions.InvalidShowException;
import com.example.showspot.exceptions.UserNotFoundException;
import com.example.showspot.models.Booking;
import com.example.showspot.models.Show;
import com.example.showspot.models.ShowSeat;
import com.example.showspot.models.User;
import com.example.showspot.models.enums.BookingStatus;
import com.example.showspot.models.enums.ShowSeatStatus;
import com.example.showspot.repositories.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@Service
public class BookingService  {
    private UserRepository userRepository;
    private BookingRepository bookingRepository;
    private ShowRepository showRepository;
    private ShowSeatRepository showSeatRepository;
    private PriceCalculatorService priceCalculatorService;

    public BookingService(UserRepository userRepository, BookingRepository bookingRepository,
                          ShowRepository showRepository,
                           ShowSeatRepository showSeatRepository,PriceCalculatorService priceCalculatorService){

        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.showRepository = showRepository;
        this.showSeatRepository = showSeatRepository;
        this.priceCalculatorService = priceCalculatorService;
    }

    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Booking createBooking(Long userId, Long showId, List<Long> showSeatIds) throws UserNotFoundException, InvalidShowException {

        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new UserNotFoundException("User "+userId+" does not exist");
        }

        User user = optionalUser.get();

        Optional<Show> optionalShow = showRepository.findById(showId);

        if(optionalShow.isEmpty()){
            throw new InvalidShowException("Invalid Show "+ showId);
        }

        Show show = optionalShow.get();

        List<ShowSeat> showSeats = showSeatRepository.findAllById(showSeatIds);

        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new InvalidShowException("Show seat not available :"+ showSeat.getId());
            }
        }

        for(ShowSeat showSeat: showSeats){
            showSeat.setShowSeatStatus(ShowSeatStatus.BLOCKED);
            showSeatRepository.save(showSeat);
        }

        Booking booking = new Booking();
        booking.setShowSeats(showSeats);
        booking.setBookedBy(user);
        booking.setBookingStatus(BookingStatus.PENDING);
        booking.setAmount(priceCalculatorService.calculatePrice(showSeats, show));

        //Call the payment Service for the payment.
        // Based on the payment status, we will update the booking status.

        booking = bookingRepository.save(booking);
        return booking;

    }

}
