package com.gym.web.webappsv.payload;


import com.gym.web.webappsv.model.Course;

import java.util.Set;

public class CourseTypeRequest {

    private String name;

    private String describer;

    private Set<Course> courses;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescriber() {
        return describer;
    }

    public void setDescriber(String describer) {
        this.describer = describer;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }
}
