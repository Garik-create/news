package ru.home.news.service;

import ru.home.news.dto.NewsDto;
import ru.home.news.model.News;
import ru.home.news.model.NewsType;

import java.util.List;

public interface NewsService {

    void addNews(NewsDto news);

    NewsDto getNews(long id);

    void updateNews(NewsDto news, String name);

    News deleteNews();

    List<News> getAllNews();

    List<News> getAllNewsOfTheType(NewsType type);
}
