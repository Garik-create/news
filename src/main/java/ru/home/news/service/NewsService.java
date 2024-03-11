package ru.home.news.service;

import ru.home.news.dto.NewsDto;
import ru.home.news.dto.NewsTypeDto;
import ru.home.news.model.News;
import ru.home.news.model.NewsType;

import java.util.List;

public interface NewsService {

    NewsDto addNews(NewsDto news);

    NewsDto getNews(long id);

    NewsDto updateNews(NewsDto news, long id);

    void deleteNews(Long id);

    List<NewsDto> getAllNews();

    List<NewsDto> getAllNewsOfTheType(long id);
}
