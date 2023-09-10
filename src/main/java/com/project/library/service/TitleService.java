package com.project.library.service;

import com.project.library.controller.exceptions.TitleNotFoundException;
import com.project.library.domain.Title;
import com.project.library.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleService {
    @Autowired
    private TitleRepository repository;

    public List<Title> getAllTitles() {
        return repository.findAll();
    }

    public Title saveTitle(final Title title) {
        return repository.save(title);
    }

    public Title getTitle(final Integer id) throws TitleNotFoundException {
        return repository.findById(id).orElseThrow(TitleNotFoundException::new);
    }

    public Title getTitleByName(final String name){
        return repository.findByName(name);
    }

    public void deleteTitle(Integer id) {
        repository.deleteById(id);
    }
}
