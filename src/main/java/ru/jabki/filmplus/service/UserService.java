package ru.jabki.filmplus.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import ru.jabki.filmplus.exception.BadRequestException;
import ru.jabki.filmplus.model.FriendRequest;
import ru.jabki.filmplus.model.User;
import ru.jabki.filmplus.repository.UserRepository;

import java.util.HashSet;

@Service
@RequiredArgsConstructor
public class UserService {

    private static final HashSet<User> users = new HashSet<>();

    private final UserRepository userRepository;

    @Transactional(rollbackFor = Exception.class)
    public User create(final User user) {
        validate(user);
        return userRepository.insert(user);
    }

    @Transactional(readOnly = true)
    public User getById(final Long id) {
        return userRepository.getById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public User update(final User user) {
        validate(user);
        return userRepository.update(user);
    }

    public void addFriend(final FriendRequest request) {
        final User user = getById(request.getId());
        user.getFriends().stream()
                .filter(el -> el.equals(request.getFriendId()))
                .findFirst().ifPresent(el -> {throw new BadRequestException("Пользователи уже дружат!");});
        final User friend = getById(request.getFriendId());
        user.getFriends().add(friend.getId());
        friend.getFriends().add(user.getId());
    }

    public void delete(final Long id) {
        users.remove(getById(id));
    }

    private void validate(final User user) {
        if (user == null) {
            throw new BadRequestException("Введите информацию о пользователе");
        }
        if (!StringUtils.hasText(user.getName())) {
            throw new BadRequestException("Укажите имя пользователя");
        }
        if (!StringUtils.hasText(user.getEmail())) {
            throw new BadRequestException("Необходимо указать адрес электронной почты пользователя");
        }
        if (!StringUtils.hasText(user.getLogin())) {
            throw new BadRequestException("Необходимо заполнить логин");
        }
        if (user.getBirthday() == null) {
            throw new BadRequestException("Необходимо заполнить дату рождения");
        }
    }
}