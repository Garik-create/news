package ru.home.news.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.home.news.model.NewsType;

@Repository
public interface NewsTypeRepository extends JpaRepository<NewsType, Long> {

}
