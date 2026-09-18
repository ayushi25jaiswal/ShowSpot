package com.example.showspot.controllers;

import com.example.showspot.dtos.CreateBookingRequestDto;
import com.example.showspot.dtos.CreateBookingResponseDto;
import com.example.showspot.dtos.ResponseStatus;
import com.example.showspot.exceptions.InvalidShowException;
import com.example.showspot.exceptions.UserNotFoundException;
import com.example.showspot.models.Booking;
import com.example.showspot.service.BookingService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class BookingController {
    BookingService bookingService;
    public BookingController(BookingService bookingService){
        this.bookingService = bookingService;
    }
    public CreateBookingResponseDto createBooking(CreateBookingRequestDto requestDto) throws UserNotFoundException, InvalidShowException {
        CreateBookingResponseDto responseDto = new CreateBookingResponseDto();

        try{
            Booking booking = bookingService.createBooking(requestDto.getUserId(), requestDto.getShowId(), requestDto.getShowSeatIds());
            responseDto.setBooking(booking);
            responseDto.setResponseStatus(ResponseStatus.SUCCESS);
        }catch (Exception e){
            responseDto.setResponseStatus(ResponseStatus.FAILURE);
        }

        return responseDto;
    }
}
