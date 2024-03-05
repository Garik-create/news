package ru.home.news.service;

import ru.home.news.dto.NewsDto;
import ru.home.news.model.News;

public interface NewsMapper {
    News toNewsEntity(NewsDto newsDto);

    News updateNewsEntity(NewsDto dto, News news);


    NewsDto toNewsDto(News news);
}
