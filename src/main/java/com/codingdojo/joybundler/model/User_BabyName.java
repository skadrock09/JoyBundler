package com.codingdojo.joybundler.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "users_babynames")
public class User_BabyName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(updatable=false)
    private Date createdAt;

    private Date updatedAt;

    private String typeofChoice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "babyname_id")
    private BabyName babyname;


    public User_BabyName() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BabyName getBabyname() {
        return babyname;
    }

    public void setBabyname(BabyName babyname) {
        this.babyname = babyname;
    }

    public String getTypeofChoice() {
        return typeofChoice;
    }

    public void setTypeofChoice(String typeofChoice) {
        this.typeofChoice = typeofChoice;
    }
}
