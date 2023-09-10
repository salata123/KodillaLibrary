package com.project.library.controller;

import com.project.library.controller.exceptions.TitleNotFoundException;
import com.project.library.domain.Title;
import com.project.library.domain.TitleDto;
import com.project.library.mapper.TitleMapper;
import com.project.library.service.TitleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("v1/Title")
@RequiredArgsConstructor
public class TitleController {
    private final TitleService service;
    private final TitleMapper titleMapper;

    @GetMapping
    public ResponseEntity<List<TitleDto>> getTitles() {
        List<Title> titles = service.getAllTitles();
        return ResponseEntity.ok(titleMapper.mapToTitleDtoList(titles));
    }

    @GetMapping("/{titleId}")
    public ResponseEntity<TitleDto> getTitle(@PathVariable Integer titleId) throws TitleNotFoundException {
        return ResponseEntity.ok(titleMapper.mapToTitleDto(service.getTitle(titleId)));
    }

    @DeleteMapping("/{titleId}")
    public ResponseEntity<Void> deleteTitle(@PathVariable Integer titleId) {
        service.deleteTitle(titleId);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{titleId}")
    public ResponseEntity<TitleDto> updateTitle(@PathVariable Integer titleId, @RequestBody TitleDto titleDto) {
        return ResponseEntity.ok(new TitleDto(1, "Book name update test", "Author update test", LocalDate.of(2010, 1, 1)));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> createTitle(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        service.saveTitle(title);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    public ResponseEntity<TitleDto> updateTitle(@RequestBody TitleDto titleDto){
        Title title = titleMapper.mapToTitle(titleDto);
        Title savedTitle = service.saveTitle(title);
        return  ResponseEntity.ok(titleMapper.mapToTitleDto(savedTitle));
    }
}
