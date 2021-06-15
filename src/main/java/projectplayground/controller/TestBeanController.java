package projectplayground.controller;


import javax.faces.bean.ManagedBean;

@ManagedBean
public class TestBeanController {

    public String showHello()
    {
        return "Hello from TestBean";
    }
}
