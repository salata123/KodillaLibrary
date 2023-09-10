package com.project.library.repository;

import com.project.library.domain.Rental;
import com.project.library.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    @Override
    List<User> findAll();

    @Override
    User save (User user);

    @Override
    Optional<User> findById(Integer id);

    @Override
    void deleteById (Integer id);
}
