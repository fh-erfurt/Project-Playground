package projectplayground.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import projectplayground.domains.User;
import projectplayground.repositories.user.UserRepository;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *  The IndexController with its class IndexController is used to show the greeting to the user and conntects the userRepository to the Controller.
 *  It is possible to show on which playground the user is logged in at the moment.
 * */


@ManagedBean
@RequestScoped
public class IndexController {

    @Autowired
    private UserRepository userRepository;

    public String showGreeting(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepository.findUserByUsername(authentication.getName());
        return "Hallo " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!";
    }

    public String showCurrentPlayground()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepository.findUserByUsername(authentication.getName());
        if(currentUser.getCurrentPlayground() != null)
            return "Angemeldet bei: " + currentUser.getCurrentPlayground().getTitle();
        return "";
    }




    public String Index()
    {
        return "index";
    }
}
