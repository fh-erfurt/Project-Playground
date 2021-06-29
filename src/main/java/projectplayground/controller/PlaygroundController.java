package projectplayground.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import projectplayground.domains.Picture;
import projectplayground.domains.Playground;
import projectplayground.repositories.PictureRepository;
import projectplayground.repositories.PlaygroundRepository;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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
            var searchPlaygroundPictures = pictureRepository.findById(ID);
            if (searchPlaygroundPictures != null)
            {
                if(playground.getPictures() == null)
                    playground.setPictures(new ArrayList<Picture>());
                playground.addPicture(searchPlaygroundPictures.get());
            }
            return "playgroundDetails";
        }
        return "Error";



    }
}
