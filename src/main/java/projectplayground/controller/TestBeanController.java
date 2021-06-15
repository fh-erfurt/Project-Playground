package projectplayground.controller;



import javax.annotation.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class TestBeanController {

    public String showHello()
    {
        return "Hello from TestBean";
    }
}
