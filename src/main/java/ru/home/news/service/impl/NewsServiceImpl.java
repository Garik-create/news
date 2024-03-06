package ru.home.news.service.impl;

import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.home.news.dto.NewsDto;
import ru.home.news.model.News;
import ru.home.news.model.NewsType;
import ru.home.news.repository.NewsRepository;
import ru.home.news.service.NewsService;

import java.util.ArrayList;
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
    public void updateNews(NewsDto newsDto, long id) {

        News oldNews = newsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Такой новости не существует."));
        newsRepository.save(newsMapper.updateNewsEntity(newsDto, oldNews));
    }

    @Override
    @Transactional
    public void deleteNews(@Nonnull Long id) {

        newsRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NewsDto> getAllNews() {

        List<NewsDto> newsDtoList = new ArrayList<>();
        List<News> newsList = newsRepository.findAll();
        for (News news : newsList) {
            newsDtoList.add(newsMapper.toNewsDto(news));
        }
        return newsDtoList;
    }

    @Override
    @Transactional(readOnly = true)
    public List<NewsDto> getAllNewsOfTheType(NewsType type) {

        List<NewsDto> newsDtoList = new ArrayList<>();
        List<News> newsList = newsRepository.findAllByType(type)
                .orElseThrow(() -> new IllegalArgumentException("Такого типа не существует."));

        for (News news : newsList) {
            newsDtoList.add(newsMapper.toNewsDto(news));
        }
        return newsDtoList;
    }

}
