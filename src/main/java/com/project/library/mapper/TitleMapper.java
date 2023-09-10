package com.project.library.mapper;

import com.project.library.domain.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TitleMapper {

    public Title mapToTitle(final TitleDto titleDto){
        return new Title(
                titleDto.getId(),
                titleDto.getName(),
                titleDto.getAuthor(),
                titleDto.getReleaseDate()
        );
    }

    public TitleDto mapToTitleDto(final Title title){
        return new TitleDto(
                title.getId(),
                title.getName(),
                title.getAuthor(),
                title.getReleaseDate()
        );
    }

    public List<TitleDto> mapToTitleDtoList(final List<Title> titlesList){
        return titlesList.stream()
                .map(this::mapToTitleDto)
                .toList();
    }
}
