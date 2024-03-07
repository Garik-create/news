package ru.home.news.service;

import ru.home.news.dto.NewsDto;
import ru.home.news.model.News;
import ru.home.news.model.NewsType;

public interface NewsMapper {
    News toNewsEntity(NewsDto newsDto, NewsType newsType);

    News updateNewsEntity(NewsDto dto, News news,NewsType newsType);


    NewsDto toNewsDto(News news);
}
