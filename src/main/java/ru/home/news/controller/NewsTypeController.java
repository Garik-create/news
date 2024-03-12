package ru.home.news.controller;

import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.home.news.dto.NewsTypeDto;
import ru.home.news.service.NewsTypeService;

import java.util.List;

@Data
@Controller
@RequestMapping("/type")
public class NewsTypeController {

    private final NewsTypeService service;

//    public NewsTypeController(NewsTypeService service) {
//        this.service = service;
//    }

    @PostMapping("")
    public ResponseEntity<NewsTypeDto> createNewsType(@RequestBody NewsTypeDto newsTypeDto) {
        return ResponseEntity.ok(service.addNewsType(newsTypeDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsTypeDto> getNewsType(@PathVariable long id) {

        return ResponseEntity.ok(service.getNewsType(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsTypeDto> updateNewsType(@RequestBody NewsTypeDto newsTypeDto,
                                                      @PathVariable long id) {

        return ResponseEntity.ok(service.updateNewsType(newsTypeDto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNewsType(@PathVariable long id) {
        service.deleteNewsType(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<NewsTypeDto>> getAllTypeNews() {
        return ResponseEntity.ok(service.getAllNewsTypes());
    }
}
