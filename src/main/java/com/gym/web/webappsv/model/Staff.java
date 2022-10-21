package com.gym.web.webappsv.model;

import com.gym.web.webappsv.model.audit.DateAudit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Staff")

public class Staff extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "identify_card")
    private String identifyCard;
    @Column(name = "dob")
    private String dob;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "status")
    private boolean status;

}
