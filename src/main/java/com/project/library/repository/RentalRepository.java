package com.project.library.repository;

import com.project.library.domain.BookCopy;
import com.project.library.domain.Rental;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RentalRepository extends CrudRepository<Rental, Integer> {
    @Override
    List<Rental> findAll();

    @Override
    Rental save(Rental rental);

    @Override
    Optional<Rental> findById(Integer id);

    @Override
    void deleteById (Integer id);
}
