package com.gym.web.webappsv.DTO;

import java.time.Instant;
import java.util.Date;

public class ClassDTO {
    private Long id;
    private Instant openDate;
    private Instant closeDate;
    private Instant startDate;
    private int maxStudent;

    private Long PersonalTrainerId;

    public Long getPersonalTrainerId() {
        return PersonalTrainerId;
    }

    public void setPersonalTrainerId(Long personalTrainerId) {
        PersonalTrainerId = personalTrainerId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
