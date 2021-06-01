package projectplayground.domains;

import projectplayground.domains.java1.BaseEntity;

import javax.persistence.Entity;


@Entity
public class Account extends BaseEntity {
    private String username;
    private String password;
    private String email;
}
