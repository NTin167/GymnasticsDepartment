package com.gym.web.webappsv.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "gender")
    private String gender;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
    @Column(name = "identify_card")
    private String identifyCard;
    @Column(name = "dob")
    private String dob;
    @Column(name = "phone_number")
    private String phoneNumber;

    @OneToMany(mappedBy = "customer")
    @JsonIgnore
    private List<Subscribe> subscribes;
    public List<Subscribe> getSubscribes() {
        return subscribes == null ? null : new ArrayList<>(subscribes);
    }
    public void setSubscribe(List<Subscribe> subscribes) {
        if(subscribes == null) {
            this.subscribes = null;
        }
        else {
            this.subscribes = Collections.unmodifiableList(subscribes);
        }
    }
}
