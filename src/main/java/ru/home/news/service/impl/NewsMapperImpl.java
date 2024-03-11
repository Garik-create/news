package ru.home.news.service.impl;

import org.springframework.stereotype.Service;
import ru.home.news.dto.NewsDto;
import ru.home.news.model.News;
import ru.home.news.model.NewsType;
import ru.home.news.service.NewsMapper;

@Service
public class NewsMapperImpl implements NewsMapper {

    @Override
    public News toNewsEntity(NewsDto newsDto, NewsType newsType) {

        News news = new News();
        news.setName(newsDto.getName());
        news.setShortDescription(newsDto.getShortDescription());
        news.setDescription(newsDto.getDescription());
        news.setType(newsType);
        return news;
    }

    @Override
    public News updateNewsEntity(NewsDto dto, News news, NewsType newsType) {

        news.setName(dto.getName());
        news.setShortDescription(dto.getShortDescription());
        news.setDescription(dto.getDescription());
        news.setType(newsType);
        return news;
    }


    @Override
    public NewsDto toNewsDto(News news) {

        NewsDto dto = new NewsDto();
        dto.setName(news.getName());
        dto.setShortDescription(news.getShortDescription());
        dto.setDescription(news.getDescription());
        dto.setType(news.getType().getId());
        return dto;
    }
}
