package projectplayground.domains;
//package com.dao;
import lombok.Getter;
import lombok.Setter;
import projectplayground.repositories.account.AccountRepositoryImpl;

import javax.persistence.*;
import java.util.UUID;

// das hab ich noch importiert für den Login (Mark)
import javax.servlet.http.HttpSession;
import javax.faces.application.FacesMessage;
//import com.journaldev.jsf.dao.LoginDAO;
//import com.journaldev.jsf.util.SessionUtils;
import javax.faces.context.FacesContext;
/**
 * Account is the class for the user
 * it contains username, password and email
 * the user himself and the roles and rights can be identified with the associated userID
 * */
@Getter
@Setter
@Entity
public class Account extends BaseEntity {

    private String username;
    private String password;
    private String email;

    @Transient
    private String message;

    @OneToOne
    private User user;

}
