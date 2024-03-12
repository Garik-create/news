package ru.home.news.service.impl;

import jakarta.annotation.Nonnull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.home.news.dto.NewsDto;
import ru.home.news.model.News;
import ru.home.news.model.NewsType;
import ru.home.news.repository.NewsRepository;
import ru.home.news.repository.NewsTypeRepository;
import ru.home.news.service.NewsService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewsServiceImpl implements NewsService {


    private final NewsRepository newsRepository;

    private final NewsMapperImpl newsMapper;

    private final NewsTypeRepository newsTypeRepository;


    public NewsServiceImpl(NewsRepository newsRepository,
                           NewsMapperImpl newsMapper,
                           NewsTypeRepository newsTypeRepository) {
        this.newsRepository = newsRepository;
        this.newsMapper = newsMapper;
        this.newsTypeRepository = newsTypeRepository;
    }

    @Override
    @Transactional
    public NewsDto addNews(NewsDto newsDto) {

        long type = newsDto.type();
        NewsType newsType = newsTypeRepository.findById(type)
                .orElseThrow(
                        ()-> new IllegalArgumentException("Такого типа новости не существует!")
                );
        News news = newsMapper.toNewsEntity(newsDto, newsType);
        return newsMapper.toNewsDto(newsRepository.save(news));
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
    public NewsDto updateNews(NewsDto newsDto, long id) {

        long type = newsDto.type();
        NewsType newsType = newsTypeRepository.findById(type)
                .orElseThrow(
                        ()-> new IllegalArgumentException("Такого типа новости не существует!")
                );
        News oldNews = newsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Такой новости не существует."));
        return newsMapper.toNewsDto(newsRepository
                .save(newsMapper.updateNewsEntity(newsDto, oldNews, newsType)));
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
    public List<NewsDto> getAllNewsOfTheType(long id) {

        NewsType newsType = newsTypeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Такого типа новости нет."));
        List<NewsDto> newsDtoList = new ArrayList<>();
        List<News> newsList = newsRepository.findAllByType(newsType);

        for (News news : newsList) {
            newsDtoList.add(newsMapper.toNewsDto(news));
        }
        return newsDtoList;
    }

}
