package ru.jabki.filmplus.model;

public class FriendRequest {

    private Long id;
    private Long friendId;

    public FriendRequest(final Long id, final Long friendId) {
        this.id = id;
        this.friendId = friendId;
    }

    public Long getId() {
        return id;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }
}