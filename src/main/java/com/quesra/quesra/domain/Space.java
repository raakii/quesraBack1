package com.quesra.quesra.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "space")
public class Space {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column
    private String name;

    @OneToOne ( fetch = FetchType.EAGER)
    @JsonIgnore
    private User admin;

    public Space(String name, User admin) {
        this.name = name;
        this.admin = admin;
    }

    public Space() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }


    @Override
    public String toString() {
        return "Space{" +
                ", name='" + name + '\'' +
                ", admin=" + admin +
                '}';
    }
}
