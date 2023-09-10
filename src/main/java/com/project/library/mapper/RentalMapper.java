package com.project.library.mapper;

import com.project.library.domain.BookCopy;
import com.project.library.domain.BookCopyDto;
import com.project.library.domain.Rental;
import com.project.library.domain.RentalDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalMapper {

    public Rental mapToRental(final RentalDto rentalDto){
        return new Rental(
                rentalDto.getId(),
                rentalDto.getBookId(),
                rentalDto.getUserId(),
                rentalDto.getRentDate(),
                rentalDto.getReturnDate()
        );
    }

    public RentalDto mapToRentalDto(final Rental rental){
        return new RentalDto(
                rental.getId(),
                rental.getBookId(),
                rental.getUserId(),
                rental.getRentDate(),
                rental.getReturnDate()
        );
    }

    public List<RentalDto> mapToRentalDtoList(final List<Rental> rentalsList){
        return rentalsList.stream()
                .map(this::mapToRentalDto)
                .toList();
    }
}
