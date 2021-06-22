package projectplayground.controller;



import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class ProfileController {

    public String Index()
    {
        return "profileIndex";
    }
}
