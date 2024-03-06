package ru.home.news.service.impl;

import jakarta.annotation.Nonnull;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.home.news.dto.NewsTypeDto;
import ru.home.news.model.NewsType;
import ru.home.news.repository.NewsTypeRepository;
import ru.home.news.service.NewsTypeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class NewsTypeServiceImpl implements NewsTypeService {

    private final NewsTypeRepository repository;

    private final NewsTypeMapperImpl mapper;

    public NewsTypeServiceImpl(NewsTypeRepository repository,
                               NewsTypeMapperImpl mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    @Transactional
    public void addNewsType(NewsTypeDto type) {

        repository.save(mapper.toNewsTypeEntity(type));
    }

    @Override
    @Transactional(readOnly = true)
    public NewsTypeDto getNewsType(long id) {

        NewsType newsType = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Такой тип новости не найден.")
        );
        return mapper.toNewTypeDto(newsType);
    }

    @Override
    @Transactional
    public void updateNewsType(NewsTypeDto type, long id) {

        NewsType newsType = repository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Такой тип новости не найден.")
        );
        repository.save(mapper.updateNewsType(type, newsType));
    }

    @Override
    @Transactional
    public void deleteNewsType(@Nonnull Long id) {

        repository.deleteById( id);
    }

    @Override
    public List<NewsTypeDto> getAllNewsTypes() {

        List<NewsTypeDto> newsTypeDtos = new ArrayList<>();
        List<NewsType> newsTypes = repository.findAll();
        for (NewsType newsType : newsTypes) {
            newsTypeDtos.add(mapper.toNewTypeDto(newsType));
        }
        return newsTypeDtos;

    }
}
