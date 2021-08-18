package projectplayground.controller;



import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import projectplayground.domains.Friend;
import projectplayground.domains.Picture;
import projectplayground.domains.User;
import projectplayground.repositories.user.UserRepository;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@ManagedBean
@RequestScoped
public class FriendController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    public UserRepository userRepository ;

    public User userAccount;
    public List<User> userFriendList;

    public String searchFirstName;
    public String searchLastName;
    public List<User> foundUsers;

    public String userDoubleAddedError;


    public String Index()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepository.findUserByUsername(authentication.getName());
        List<Long> allFriendsIDs = userRepository.findAllFriends(currentUser);
        userFriendList = new ArrayList<User>();
        for (var friendID : allFriendsIDs) {
            userFriendList.add(userRepository.findById(friendID).get());
        }
        this.userDoubleAddedError = "";
        return "friendIndex";
    }

    public String SearchFriend()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepository.findUserByUsername(authentication.getName());

        if(!searchFirstName.isEmpty() || !searchLastName.isEmpty())
        {
            List<User> foundUsers= userRepository.findUsersByName(searchFirstName, searchLastName);
            this.foundUsers = foundUsers;
            this.foundUsers.removeIf(e -> e.getId().equals(currentUser.getId()));
        }
        return "friendIndex";
    }

    public String AddFriend(long ID)
    {
        try {
            this.userDoubleAddedError = "";
            Optional<User> newFriend = userRepository.findById(ID);
            if (newFriend != null) {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
                User currentUser = userRepository.findUserByUsername(authentication.getName());
                userRepository.addFriend(currentUser, newFriend.get());

                List<Long> allFriendsIDs = userRepository.findAllFriends(currentUser);
                userFriendList = new ArrayList<User>();
                for (var friendID : allFriendsIDs) {
                    userFriendList.add(userRepository.findById(friendID).get());
                }
                this.foundUsers.removeIf(e -> e.getId().equals(newFriend.get().getId()));
            }
            return "friendIndex";
        }
        catch(Exception ex)
        {
            this.userDoubleAddedError = "Sie können ein Freund nicht zwei Mal hinzufügen.";

            return "Error";
        }
    }

    public String RemoveFriend(long ID)
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepository.findUserByUsername(authentication.getName());
        User toBeDeletedFriend = userRepository.findById(ID).get();
        this.userFriendList.removeIf(u -> u.getId().equals(ID));
        userRepository.removeFriend(currentUser, toBeDeletedFriend);
        return "friendIndex";
    }
}
