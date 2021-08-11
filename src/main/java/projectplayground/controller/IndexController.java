package projectplayground.controller;



import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class IndexController {

    public String showHello()
    {
        return "Hello from TestBean";
    }

    public String showGreeting(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return "Hallo: " + authentication.getName() + "!";
    }


    public String Index()
    {
        return "index";
    }
}
