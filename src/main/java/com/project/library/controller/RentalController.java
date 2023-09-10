package com.project.library.controller;

import com.project.library.controller.exceptions.RentalNotFoundException;
import com.project.library.domain.Rental;
import com.project.library.domain.RentalDto;
import com.project.library.mapper.RentalMapper;
import com.project.library.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/Rental")
@RequiredArgsConstructor
public class RentalController {
    private final RentalService service;
    private final RentalMapper rentalMapper;

    @GetMapping
    public ResponseEntity<List<RentalDto>> getRentals() {
        List<Rental> rentals = service.getAllRentals();
        return ResponseEntity.ok(rentalMapper.mapToRentalDtoList(rentals));
    }

    @GetMapping("/{rentalId}")
    public ResponseEntity<RentalDto> getRental(@PathVariable Integer rentalId) throws RentalNotFoundException {
        return ResponseEntity.ok(rentalMapper.mapToRentalDto(service.getRental(rentalId)));
    }

    @DeleteMapping("/{rentalId}")
    public ResponseEntity<Void> deleteRental(@PathVariable Integer rentalId) {
        service.deleteRental(rentalId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{rentalId}")
    public ResponseEntity<RentalDto> updateRental(@PathVariable Integer rentalId, @RequestBody RentalDto rentalDto) {
        return ResponseEntity.ok(new RentalDto(1, 1, 1, LocalDate.of(2023, 4, 3), LocalDate.of(2023, 4, 6)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createRental(@RequestBody RentalDto rentalDto) {
        Rental rental = rentalMapper.mapToRental(rentalDto);
        service.saveRental(rental);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/return")
    public ResponseEntity<RentalDto> returnRental(@RequestBody Integer rentalId){
        service.saveReturn(rentalId);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<RentalDto> updateRental(@RequestBody RentalDto rentalDto){
        Rental rental = rentalMapper.mapToRental(rentalDto);
        Rental savedRental = service.saveRental(rental);
        return  ResponseEntity.ok(rentalMapper.mapToRentalDto(savedRental));
    }
}
