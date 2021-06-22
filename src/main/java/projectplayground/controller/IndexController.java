package projectplayground.controller;



import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class IndexController {

    public String showHello()
    {
        return "Hello from TestBean";
    }


    public String Index()
    {
        return "index";
    }
}
