package ru.home.news.service.impl;

import org.springframework.stereotype.Service;
import ru.home.news.dto.NewsTypeDto;
import ru.home.news.model.NewsType;
import ru.home.news.service.NewsTypeMapper;

@Service
public class NewsTypeMapperImpl implements NewsTypeMapper {

    @Override
    public NewsType toNewsTypeEntity(NewsTypeDto newsTypeDto) {

        NewsType newsType = new NewsType();
        newsType.setTypeName(newsTypeDto.getTypeName());
        newsType.setTypeColour(newsTypeDto.getTypeColour());
        return newsType;
    }

    @Override
    public NewsTypeDto toNewTypeDto(NewsType newsType) {

        NewsTypeDto dto = new NewsTypeDto();
        dto.setTypeName(newsType.getTypeName());
        dto.setTypeColour(newsType.getTypeColour());
        return dto;
    }

    @Override
    public NewsType updateNewsType(NewsTypeDto newsTypeDto, NewsType newsType) {

        newsType.setTypeName(newsTypeDto.getTypeName());
        newsType.setTypeColour(newsTypeDto.getTypeColour());
        return newsType;
    }
}
