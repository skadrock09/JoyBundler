package com.codingdojo.joybundler.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "baby_name")
public class BabyName {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min=2,message="Name must be at least 2 characters")
    private String name;
    @Column(updatable = false)

    private Date createdAt;

    private Date updatedAt;

    @Size(min=2,message="Meaning must be at least 2 characters")
    private String description;

    @Size(min=1,message="Select at least one")
    private String Gender;

    @Size(min=2,message = "Origin must be at least 2 characters")
    private String Origin;
    private int CountLikes;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_babynames",
            joinColumns = @JoinColumn(name = "babyname_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    public BabyName() {
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public int getCountLikes() {
        return CountLikes;
    }

    public void setCountLikes(int countLikes) {
        CountLikes = countLikes;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }


//

}
