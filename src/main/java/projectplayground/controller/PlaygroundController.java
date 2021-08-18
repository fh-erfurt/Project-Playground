package projectplayground.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import projectplayground.domains.*;
import projectplayground.repositories.playground.PlaygroundRepository;
import projectplayground.repositories.picture.PictureRepository;
import projectplayground.repositories.user.UserRepository;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 *  The PlaygroundController with its class PlaygroundController is used to manage and list the playgrounds.
 *  It's important to handle the searching, show details, find the playground by name or street and show pictures from the playground.
 *  It is used to Login and Logoff at a playground by the user.
 * */


@ManagedBean
@RequestScoped
@Getter
@Setter
public class PlaygroundController {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private PlaygroundRepository playgroundRepository;
    @Autowired
    private PictureRepository pictureRepository;
    @Autowired
    private UserRepository userRepository;

    public Playground playground;
    public List<Playground> allPlaygrounds;

    //Informations needed to search for a playground in SearchPlayground() method
    public String searchPlaygroundName;
    public String searchStreetName;
    public List<Playground> foundPlaygrounds;


    public String Index()
    {
        allPlaygrounds = playgroundRepository.findAll();
        return "playgroundIndex";
    }

    public String Search()
    {
        return "playgroundSearch";
    }


    public void SetupPlaygroundDetails(Playground playground)
    {
        var searchPlaygroundPictures = pictureRepository.findAllPicturesByPlaygroundId(playground.getId());
        if (searchPlaygroundPictures != null)
        {
            if(playground.getPictures() == null)
                playground.setPictures(new ArrayList<Picture>());
            for (Picture picture : searchPlaygroundPictures)
            {
                playground.addPicture(picture);
            }
        }

        var searchPlaygroundDevices = playgroundRepository.findAllDevicesByPlaygroundID(playground.getId());
        if (searchPlaygroundDevices != null)
        {
            if(playground.getDevices() == null)
                playground.setDevices(new ArrayList<Device>());
            for (Device device : searchPlaygroundDevices)
            {
                playground.addDevice(device);
            }
        }

        var searchPlaygroundExpansions = playgroundRepository.findAllExpansionsByPlaygroundID(playground.getId());
        if (searchPlaygroundExpansions != null)
        {
            if(playground.getExpansions() == null)
                playground.setExpansions(new ArrayList<Expansion>());
            for (Expansion expansion : searchPlaygroundExpansions)
            {
                playground.addExpansion(expansion);
            }
        }
    }
    public String Details(long searchPlaygroundID)
    {
        long ID = searchPlaygroundID;
        var searchPlayground = playgroundRepository.findById(ID);
        if (searchPlayground != null)
        {
            playground = searchPlayground.get();
            SetupPlaygroundDetails(playground);
            return "playgroundDetails";
        }
        return "Error";
    }

    public String SearchPlayground()
    {
        if(!searchPlaygroundName.isEmpty() || !searchStreetName.isEmpty())
        {
            List<Playground> searchPlaygrounds= playgroundRepository.findAllPlaygrounds(searchPlaygroundName, searchStreetName);
            this.foundPlaygrounds = searchPlaygrounds;
        }
        return "playgroundSearch";
    }

    public String LoginPlayground(long playgroundID)
    {
        Playground playground = playgroundRepository.findById(playgroundID).get();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User currentUser = userRepository.findUserByUsername(authentication.getName());
        if(currentUser.getCurrentPlayground() != null)
        {
            if(currentUser.getCurrentPlayground().getId().equals(playgroundID))
            {
                return "loggedInTwice";
            }
            playgroundRepository.deductPlaygroundCounter(currentUser.getCurrentPlayground(), currentUser.getChildren());
        }
        userRepository.loginUserToPlayground(currentUser, playground);
        playgroundRepository.addPlaygroundCounter(playground, currentUser.getChildren());
        return "loginPlaygroundSuccess";
    }

    public String LogoutPlayground()
    {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            User currentUser = userRepository.findUserByUsername(authentication.getName());
            if(currentUser.getCurrentPlayground() == null)
                return "logoutPlaygroundError";
            playgroundRepository.deductPlaygroundCounter(currentUser.getCurrentPlayground(), currentUser.getChildren());
            userRepository.logoutUserFromPlayground(currentUser);
            return "logoutPlaygroundSuccess";
    }
}
