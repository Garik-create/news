package ru.home.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.home.news.model.NewsType;

public interface NewsTypeRepository extends JpaRepository<NewsType, Long> {

}
