package ru.home.news.service;

import ru.home.news.dto.NewsDto;
import ru.home.news.model.News;

public interface NewsMapper {
    News toNewsEntity(NewsDto newsDto);

    NewsDto toNewsDto(News news);
}
