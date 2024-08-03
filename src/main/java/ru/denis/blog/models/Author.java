package ru.denis.blog.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "author_id")
    private int author_id;

    @Column(name = "name")
    private String name;


    @Column(name = "registration_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registration_time;

//    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
//    private List<Post> posts;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }


    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getRegistration_time() {
        return registration_time;
    }

    public void setRegistration_time(Date registration_time) {
        this.registration_time = registration_time;
    }

}
