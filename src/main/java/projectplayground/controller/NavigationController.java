package projectplayground.controller;



import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class NavigationController {

    public String Index()
    {
        return "index";
    }

    public String PlaygroundIndex()
    {
        return "playgroundIndex";
    }
}
