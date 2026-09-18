package com.example.showspot.service;

import com.example.showspot.models.Show;
import com.example.showspot.models.ShowSeat;
import com.example.showspot.models.ShowSeatType;
import com.example.showspot.repositories.ShowSeatTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceCalculatorService {
    private ShowSeatTypeRepository showSeatTypeRepository;

    public PriceCalculatorService(ShowSeatTypeRepository showSeatTypeRepository){
        this.showSeatTypeRepository = showSeatTypeRepository;
    }



    public int calculatePrice(List<ShowSeat>showSeats, Show show){
        List<ShowSeatType>showSeatTypes = showSeatTypeRepository.findAllByShow(show);

        int amount = 0;

        for(ShowSeat showSeat: showSeats){
            for(ShowSeatType showSeatType: showSeatTypes){
                if(showSeat.getSeat().getSeatType().equals(showSeatType.getSeatType())){
                    amount += showSeatType.getPrice();
                    break;
                }
            }
        }
        return amount;
    }

}
