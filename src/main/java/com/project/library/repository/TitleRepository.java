package com.project.library.repository;

import com.project.library.domain.Title;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TitleRepository extends CrudRepository<Title, Integer> {
    @Override
    List<Title> findAll();

    @Override
    Title save(Title title);

    @Override
    Optional<Title> findById(Integer id);

    Title findByName(String name);

    @Override
    void deleteById (Integer id);
}
