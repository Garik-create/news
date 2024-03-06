package ru.home.news.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.home.news.dto.NewsDto;
import ru.home.news.dto.NewsTypeDto;
import ru.home.news.service.NewsService;

import java.util.Optional;

@Controller
@RequestMapping("/news")
public class NewsController {

    private final NewsService service;

    public NewsController(NewsService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<NewsDto> createNews(@RequestBody NewsDto newsDto) {
        return ResponseEntity.ok(service.addNews(newsDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsDto> readNews(@PathVariable int id) {

        return ResponseEntity.ok(service.getNews(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsDto> updateNews(@PathVariable int id,
                                              @RequestBody NewsDto newsDto) {

        return ResponseEntity.ok(service.updateNews(newsDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNews(@PathVariable Long id) {

        service.deleteNews(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("")
    public ResponseEntity<?> getAllNews() {
        return ResponseEntity.of(Optional.ofNullable(service.getAllNews()));
    }

    @GetMapping("/type/{id}")
    public ResponseEntity<?> getAllNewsTheType(@PathVariable long id) {

        return ResponseEntity.ok(service.getAllNewsOfTheType(id));
    }
}
