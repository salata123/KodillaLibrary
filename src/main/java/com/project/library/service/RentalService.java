package com.project.library.service;

import com.project.library.controller.exceptions.RentalNotFoundException;
import com.project.library.domain.BookCopy;
import com.project.library.domain.Rental;
import com.project.library.repository.BookCopyRepository;
import com.project.library.repository.RentalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class RentalService {
    @Autowired
    private RentalRepository repository;
    @Autowired
    private BookCopyService bookCopyService;

    public List<Rental> getAllRentals() {
        return repository.findAll();
    }

    public Rental saveRental(final Rental rental) {
        try{
            BookCopy bookCopy = bookCopyService.getBookCopy(rental.getBookId());
            if(bookCopy.getStatus().equals("in stock")){
                bookCopy.setStatus("rented");
                return repository.save(rental);
            } else {
                System.out.println("This book is not available for renting. Please choose another book.");
            }
        }catch (Exception e){
            System.out.println("Book not found.");
        }
        return null;
    }

    public Rental saveReturn(final Integer id){
        Optional<Rental> optionalRental = repository.findById(id);

//        optionalRental.ifPresent();

        if(optionalRental.isPresent()){
            Rental rental = optionalRental.get();
        }

        Rental rental = optionalRental.get();

        try{
            BookCopy bookCopy = bookCopyService.getBookCopy(rental.getBookId());
            if(bookCopy.getStatus().equals("rented")){
                bookCopy.setStatus("in stock");
                rental.setReturnDate(LocalDate.now());
                return repository.save(rental);
            } else {
                System.out.println("This book is already in stock. Please check if rental ID is valid.");
            }
        }catch (Exception e){
            System.out.println("Book not found.");
        }
        return null;
    }

    public Rental getRental(final Integer id) throws RentalNotFoundException {
        return repository.findById(id).orElseThrow(RentalNotFoundException::new);
    }

    public void deleteRental(Integer id) {
        repository.deleteById(id);
    }
}
