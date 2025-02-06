package ru.jabki.filmplus.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jabki.filmplus.model.Review;
import ru.jabki.filmplus.model.ReviewRequest;
import ru.jabki.filmplus.service.ReviewService;

@RestController
@Tag(name = "Рецензии")
@RequestMapping("/api/v1/review")
public class ReviewController {

    private final ReviewService reviewService;

    public ReviewController(final ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    @Operation(summary = "Написать отзыв")
    public Review create(@RequestBody final ReviewRequest review) {
        return reviewService.create(review);
    }
}