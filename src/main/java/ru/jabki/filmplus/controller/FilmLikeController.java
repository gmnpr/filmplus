package ru.jabki.filmplus.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jabki.filmplus.model.LikeRequest;
import ru.jabki.filmplus.service.FilmService;

@RestController
@Tag(name = "Лайки")
@RequestMapping("/api/v1/like")
public class FilmLikeController {

    private final FilmService filmService;

    public FilmLikeController(final FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping
    public void likeFilm(@RequestBody final LikeRequest request) {
        filmService.like(request);
    }
}