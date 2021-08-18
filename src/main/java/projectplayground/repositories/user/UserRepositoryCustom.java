package projectplayground.repositories.user;

import projectplayground.domains.Friend;
import projectplayground.domains.User;

import java.util.List;
import java.util.Optional;

public interface UserRepositoryCustom {

    User findUserByUsername(String userName);
    List<User> findUsersByName(String firstName, String lastName);
    void addFriend(User currentUser, User newFriend);
    void removeFriend(User currentUser, User toBeDeletedFriend);
    List<Long> findAllFriends(User currentUser);
}
