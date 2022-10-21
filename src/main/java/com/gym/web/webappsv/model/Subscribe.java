package com.gym.web.webappsv.model;

import com.gym.web.webappsv.model.audit.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Subscribe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscribe extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "status")
    private int status;
    @Column(name = "date_subscribe")
    private Date dateSubscribe;

    @OneToMany(mappedBy = "subscribe")
    private List<Bill> bills;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "class_id")
    private Class aClass;
}
