package ru.home.news.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.home.news.dto.NewsDto;
import ru.home.news.model.News;
import ru.home.news.model.NewsType;
import ru.home.news.repository.NewsRepository;
import ru.home.news.service.NewsService;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {


    private final NewsRepository newsRepository;

    private final NewsMapperImpl newsMapper;


    public NewsServiceImpl(NewsRepository newsRepository, NewsMapperImpl newsMapper) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
    }

    @Override
    @Transactional
    public void addNews(NewsDto newsDto) {

        newsRepository.save(newsMapper.toNewsEntity(newsDto));
    }

    @Override
    @Transactional(readOnly = true)
    public NewsDto getNews(long id) {

        News news = newsRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Такой новости не существует.")
        );
        return newsMapper.toNewsDto(news);
    }

    @Override
    @Transactional
    public void updateNews(NewsDto newsDto, String name) {

        News oldNews = newsRepository.findByName(name)
                .orElseThrow(() -> new IllegalArgumentException("Такой новости не существует."));
        NewsDto oldNewsDto = newsMapper.toNewsDto(oldNews);
        NewsDto updatedNewsDto = new NewsDto();
//        updatedNewsDto.setType(oldNewsDto);
//
//        oldNews.setDescription(news.getDescription());
//        oldNews.setName(news.getName());
//        oldNews.setType(news.getType());
//        newsRepository.save(news);
    }

    @Override
    public News deleteNews() {
        return null;
    }

    @Override
    public List<News> getAllNews() {
        return null;
    }

    @Override
    public List<News> getAllNewsOfTheType(NewsType type) {
        return null;
    }
}
