package com.example.pollingapp.models;

import com.example.pollingapp.models.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
public class Role
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;


    @Enumerated(EnumType.STRING)
    @Column(length = 50)
    private RoleName role;
    public Role() {
    }


    public Role(Long id, RoleName role) {
        Id = id;
        this.role = role;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public RoleName getRole() {
        return role;
    }

    public void setRole(RoleName role) {
        this.role = role;
    }
}
