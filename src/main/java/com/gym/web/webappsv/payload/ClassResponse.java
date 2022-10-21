package com.gym.web.webappsv.payload;

import com.gym.web.webappsv.model.Course;
import com.gym.web.webappsv.model.PersonalTrainer;
import com.gym.web.webappsv.model.Subscribe;

import javax.persistence.Column;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ClassResponse {
    private Long id;
    private Instant openDate;
    private Instant closeDate;
    private Instant startDate;
    private int maxStudent;
    private String personalTrainerId;
    private String courseId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPersonalTrainerId() {
        return personalTrainerId;
    }

    public void setPersonalTrainerId(String personalTrainerId) {
        this.personalTrainerId = personalTrainerId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    private List<Subscribe> subscribes;

    private Instant createdAt;

    private Instant updatedAt;

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Instant getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Instant openDate) {
        this.openDate = openDate;
    }

    public Instant getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Instant closeDate) {
        this.closeDate = closeDate;
    }

    public Instant getStartDate() {
        return startDate;
    }

    public void setStartDate(Instant startDate) {
        this.startDate = startDate;
    }

    public int getMaxStudent() {
        return maxStudent;
    }

    public void setMaxStudent(int maxStudent) {
        this.maxStudent = maxStudent;
    }


    public List<Subscribe> getSubscribes() {
        return subscribes;
    }

    public void setSubscribes(List<Subscribe> subscribes) {
        this.subscribes = subscribes;
    }
}
