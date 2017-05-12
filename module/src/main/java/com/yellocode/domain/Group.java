package com.yellocode.domain;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "playlist")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "group_name", nullable = false, insertable = true, updatable = true, length = 255)
    private String groupName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_group", joinColumns = {
            @JoinColumn(name = "group_id", nullable = false, updatable = true)
    }, inverseJoinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = true) })
    private List<User> users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", users=" + users +
                '}';
    }
}
