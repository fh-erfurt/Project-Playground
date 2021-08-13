package projectplayground.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
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

    public String Details(long searchPlaygroundID)
    {
        long ID = searchPlaygroundID;
        var searchPlayground = playgroundRepository.findById(ID);
        if (searchPlayground != null)
        {
            playground = searchPlayground.get();
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
            return "playgroundDetails";
        }
        return "Error";
    }

    public String SearchPlayground()
    {
        if(!searchPlaygroundName.isEmpty() || !searchStreetName.isEmpty())
        {
            List<Playground> searchPlaygrounds= playgroundRepository.findAllPlaygrounds(searchPlaygroundName, searchStreetName);
            for (Playground playground: searchPlaygrounds )
            {
                System.out.println(playground.getTitle());
            }
            this.foundPlaygrounds = searchPlaygrounds;
        }
        return "playgroundSearch";
    }
}
