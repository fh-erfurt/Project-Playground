package projectplayground.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import projectplayground.domains.Device;
import projectplayground.domains.Expansion;
import projectplayground.domains.Picture;
import projectplayground.domains.Playground;
import projectplayground.repositories.playground.PlaygroundRepository;
import projectplayground.repositories.picture.PictureRepository;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

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
    public Playground playground;
    public List<Playground> allPlaygrounds;


    //Informations needed to search for a playground in SearchPlayground() method
    public String searchPlaygroundName;
    public String searchStreetName;
    public List<Playground> foundPlaygrounds;
//    public long searchPlaygroundID;


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

            for (var device: playground.getDevices())
            {
                System.out.println("qwertz: " + device.getTitle());
            }
            for (var expansion: playground.getExpansions())
            {
                System.out.println("qwertz: " + expansion.getTitle());
            }

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
}
