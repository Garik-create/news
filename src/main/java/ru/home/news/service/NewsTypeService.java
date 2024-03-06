package ru.home.news.service;

import ru.home.news.dto.NewsTypeDto;
import ru.home.news.model.NewsType;

import java.util.List;

public interface NewsTypeService {

    void addNewsType(NewsTypeDto type);

    NewsTypeDto getNewsType(long id);

    void updateNewsType(NewsTypeDto type, long id);

    void deleteNewsType(Long id);

    List<NewsTypeDto> getAllNewsTypes();
}
