package com.gym.web.webappsv.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Table(name = "Course")
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    @JsonIgnore
    private Set<Class> classes;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "coursetype_id", nullable = false)
    private CourseType courseType;
}
