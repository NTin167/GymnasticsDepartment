package com.gym.web.webappsv.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.gym.web.webappsv.model.audit.DateAudit;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Class")
public class Class extends DateAudit {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "open_date")
    private Instant openDate;
    @Column(name = "close_date")
    private Instant closeDate;
    @Column(name = "start_date")
    private Instant startDate;
    @Column(name = "max_student")
    private int maxStudent;

    // ManyToOne có nhiều lớp thuộc 1 PT.
    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "personaltrainer_id", nullable = false)// thông qua khóa ngoại personaltrainer_id
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hash code
    @ToString.Exclude // không sử dụng trường này trong toString.
    private PersonalTrainer personalTrainer;

    @ManyToOne()
    @JsonIgnore
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @OneToMany(mappedBy = "aClass")
    private List<Subscribe> subscribes;

}
