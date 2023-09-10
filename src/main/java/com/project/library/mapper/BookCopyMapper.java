package com.project.library.mapper;

import com.project.library.domain.BookCopy;
import com.project.library.domain.BookCopyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookCopyMapper {

    public BookCopy mapToBookCopy(final BookCopyDto bookCopyDto){
        return new BookCopy(
                bookCopyDto.getId(),
                bookCopyDto.getTitleId(),
                bookCopyDto.getStatus()
        );
    }

    public BookCopyDto mapToBookCopyDto(final BookCopy bookCopy){
        return new BookCopyDto(
                bookCopy.getId(),
                bookCopy.getTitleId(),
                bookCopy.getStatus()
        );
    }

    public List<BookCopyDto> mapToBookCopyDtoList(final List<BookCopy> bookCopiesList){
        return bookCopiesList.stream()
                .map(this::mapToBookCopyDto)
                .toList();
    }
}
