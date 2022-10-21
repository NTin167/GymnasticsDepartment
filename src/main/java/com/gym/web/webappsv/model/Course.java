package com.gym.web.webappsv.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "Course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "duration")
    private Long duration;
    @Column(name = "status")
    private int status;
    @Column(name = "price")
    private float price;

    @OneToMany(mappedBy = "course")
    private Set<Class> classes;

    @ManyToOne()
    @JoinColumn(name = "coursetype_id", nullable = false)
    private CourseType courseType;
}
