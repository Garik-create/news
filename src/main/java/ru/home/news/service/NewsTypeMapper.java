package ru.home.news.service;

import ru.home.news.dto.NewsDto;
import ru.home.news.dto.NewsTypeDto;
import ru.home.news.model.News;
import ru.home.news.model.NewsType;

public interface NewsTypeMapper {

    NewsType toNewsTypeEntity(NewsTypeDto newsTypeDto);

    NewsTypeDto toNewTypeDto(NewsType newsType);

    NewsType updateNewsType(NewsTypeDto newsTypeDto, NewsType newsType);
}
