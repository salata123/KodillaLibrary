package com.project.library.controller;

import com.project.library.controller.exceptions.BookCopyNotFoundException;
import com.project.library.domain.BookCopy;
import com.project.library.domain.BookCopyDto;
import com.project.library.mapper.BookCopyMapper;
import com.project.library.service.BookCopyService;
import com.project.library.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/BookCopy")
@RequiredArgsConstructor
public class BookCopyController {
    private final BookCopyService service;
    private final BookCopyMapper bookCopyMapper;

    @GetMapping
    public ResponseEntity<List<BookCopyDto>> getBookCopies() {
        List<BookCopy> bookCopies = service.getAllBookCopies();
        return ResponseEntity.ok(bookCopyMapper.mapToBookCopyDtoList(bookCopies));
    }

    @GetMapping("/{bookCopyId}")
    public ResponseEntity<BookCopyDto> getBookCopy(@PathVariable Integer bookCopyId) throws BookCopyNotFoundException {
        return ResponseEntity.ok(bookCopyMapper.mapToBookCopyDto(service.getBookCopy(bookCopyId)));
    }

    @DeleteMapping("/{bookCopyId}")
    public ResponseEntity<Void> deleteBookCopy(@PathVariable Integer bookCopyId) {
        service.deleteBookCopy(bookCopyId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{bookCopyId}")
    public ResponseEntity<BookCopyDto> updateBookCopy(@PathVariable Integer bookCopyId, @RequestBody BookCopyDto bookCopyDto) {
        return ResponseEntity.ok(new BookCopyDto(1, 1, "Edit status test"));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createBookCopy(@RequestBody BookCopyDto bookCopyDto) {
        BookCopy bookCopy = bookCopyMapper.mapToBookCopy(bookCopyDto);
        service.saveBookCopy(bookCopy);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<BookCopyDto> updateBookCopy(@RequestBody BookCopyDto bookCopyDto){
        BookCopy bookCopy = bookCopyMapper.mapToBookCopy(bookCopyDto);
        BookCopy savedBookCopy = service.saveBookCopy(bookCopy);
        return  ResponseEntity.ok(bookCopyMapper.mapToBookCopyDto(savedBookCopy));
    }

    @GetMapping("/count/{bookTitle}")
    public ResponseEntity<Integer> getNumberOfCopiesWithTitle(@PathVariable String bookTitle){
        System.out.println("Name: " + bookTitle);
        System.out.println(service.getNumberOfBookCopiesByTitle(bookTitle));
        Integer count = service.getNumberOfBookCopiesByTitle(bookTitle);
        System.out.println("count: " + count );
        return ResponseEntity.ok(count);
    }
}
