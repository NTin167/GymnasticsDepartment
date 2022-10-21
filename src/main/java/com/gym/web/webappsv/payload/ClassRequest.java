package com.gym.web.webappsv.payload;

import com.gym.web.webappsv.model.Course;
import com.gym.web.webappsv.model.PersonalTrainer;
import com.gym.web.webappsv.model.Subscribe;

import java.time.Instant;
import java.util.Date;
import java.util.List;

public class ClassRequest {
    private Instant openDate;
    private Instant closeDate;
    private Instant startDate;
    private int maxStudent;
    private Long personalTrainerId;
    private Long courseId;

    public Long getPersonalTrainerId() {
        return personalTrainerId;
    }

    public void setPersonalTrainerId(Long personalTrainerId) {
        this.personalTrainerId = personalTrainerId;
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    private List<Subscribe> subscribes;

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
