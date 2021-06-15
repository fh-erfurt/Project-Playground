package projectplayground.controller;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

@ManagedBean
@RequestScoped
public class TestBeanController {

    public String showHello()
    {
        return "Hello from TestBean";
    }
}
