package com.example.pollingapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user",uniqueConstraints = {@UniqueConstraint(columnNames = "username"),@UniqueConstraint(columnNames = "emailId")})
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotNull
    private String name;
    @NotNull
    private String userName;

    @NotNull
    private String emailId;

    @NotNull
    private String password;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles=new HashSet<>();

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public User() {
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public User(String name, String userName, String emailId, String password) {
        this.name = name;
        this.userName = userName;
        this.emailId = emailId;
        this.password = password;
    }
}
