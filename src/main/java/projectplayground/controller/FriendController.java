package projectplayground.controller;



import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class FriendController {
    public String Index()
    {
        return "friendIndex";
    }
}
