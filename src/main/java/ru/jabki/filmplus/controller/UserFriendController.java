package ru.jabki.filmplus.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.jabki.filmplus.model.FriendRequest;
import ru.jabki.filmplus.service.UserService;

@RestController
@Tag(name = "Дружбааа")
@RequestMapping("/api/v1/friend")
public class UserFriendController {

    private final UserService userService;

    public UserFriendController(final UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @Operation(summary = "Добавить друга")
    public void create(@RequestBody final FriendRequest request) {
        userService.addFriend(request);
    }
}