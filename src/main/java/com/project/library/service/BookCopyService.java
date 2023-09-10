package com.project.library.service;

import com.project.library.controller.exceptions.BookCopyNotFoundException;
import com.project.library.domain.BookCopy;
import com.project.library.domain.Title;
import com.project.library.repository.BookCopyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookCopyService {
    @Autowired
    private BookCopyRepository repository;
    @Autowired
    private TitleService titleService;

    public List<BookCopy> getAllBookCopies() {
        return repository.findAll();
    }

    public BookCopy saveBookCopy(final BookCopy bookCopy) {
        return repository.save(bookCopy);
    }

    public BookCopy getBookCopy(final Integer id) throws BookCopyNotFoundException {
        return repository.findById(id).orElseThrow(BookCopyNotFoundException::new);
    }

    public void deleteBookCopy(Integer id) {
        repository.deleteById(id);
    }

    public Integer getNumberOfBookCopiesByTitle(String name){
        Title title = titleService.getTitleByName(name);
        int titleId = title.getId();
        List<BookCopy> list = repository.findByTitleId(titleId);
        return list.size();
    }
}
