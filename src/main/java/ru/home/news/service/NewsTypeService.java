package ru.home.news.service;

import ru.home.news.dto.NewsTypeDto;
import ru.home.news.model.NewsType;

import java.util.List;

public interface NewsTypeService {

    void addNewsType(NewsTypeDto type);

    NewsType getNewsType();

    NewsType updateNewsType(NewsType type);

    NewsType deleteNewsType();

    List<NewsType> getAllNewsTypes();
}
