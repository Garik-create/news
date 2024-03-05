package ru.home.news.service.impl;

import org.springframework.stereotype.Service;
import ru.home.news.dto.NewsDto;
import ru.home.news.model.News;
import ru.home.news.service.NewsMapper;

@Service
public class NewsMapperImpl implements NewsMapper {

    @Override
    public News toNewsEntity(NewsDto newsDto) {

        News news = new News();
        news.setName(newsDto.getName());
        news.setShortDescription(newsDto.getShortDescription());
        news.setDescription(newsDto.getDescription());
        news.setType(newsDto.getType());
        return news;
    }

    @Override
    public NewsDto toNewsDto(News news) {

        NewsDto dto = new NewsDto();
        dto.setName(news.getName());
        dto.setShortDescription(news.getShortDescription());
        dto.setDescription(news.getDescription());
        dto.setType(news.getType());
        return dto;
    }
}
