package ru.home.news.service;

import ru.home.news.dto.NewsTypeDto;

import java.util.List;

public interface NewsTypeService {

    NewsTypeDto addNewsType(NewsTypeDto type);

    NewsTypeDto getNewsType(long id);

    NewsTypeDto updateNewsType(NewsTypeDto type, long id);

    void deleteNewsType(Long id);

    List<NewsTypeDto> getAllNewsTypes();
}
