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
        news.setName(newsDto.name());
        news.setShortDescription(newsDto.shortDescription());
        news.setDescription(newsDto.description());
        news.setType(newsType);
        return news;
    }

    @Override
    public News updateNewsEntity(NewsDto dto, News news, NewsType newsType) {

        news.setName(dto.name());
        news.setShortDescription(dto.shortDescription());
        news.setDescription(dto.description());
        news.setType(newsType);
        return news;
    }


    @Override
    public NewsDto toNewsDto(News news) {

        //        dto.setName();
//        dto.setShortDescription();
//        dto.setDescription();
//        dto.setType();
        return new NewsDto(news.getName(),
                news.getShortDescription(),
                news.getDescription(),news.getType().getId());
    }
}
