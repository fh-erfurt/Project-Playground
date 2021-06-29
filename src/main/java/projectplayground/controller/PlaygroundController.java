package projectplayground.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import projectplayground.domains.Picture;
import projectplayground.domains.Playground;
import projectplayground.repositories.PlaygroundRepository;
import projectplayground.repositories.picture.PictureRepository;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;

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

    public String Index()
    {
        return "playgroundIndex";
    }

    public String Details()
    {
        long ID = 1;
        var searchPlayground = playgroundRepository.findById(ID);
        if (searchPlayground != null)
        {
            playground = searchPlayground.get();
            var searchPlaygroundPictures = pictureRepository.findAllPicturesByPlaygroundId(playground.getId());
            if (searchPlaygroundPictures != null)
            {
                if(playground.getPictures() == null)
                    playground.setPictures(new ArrayList<Picture>());
                System.out.println("Test123: " + searchPlaygroundPictures.size());
                for (Picture picture : searchPlaygroundPictures)
                {
                    System.out.println("Test123: " + picture.getPath());
                    playground.addPicture(picture);
                }

            }
            return "playgroundDetails";
        }
        return "Error";



    }
}
