package com.gym.web.webappsv.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "PersonalTrainer")
public class PersonalTrainer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    @OneToMany(mappedBy = "personalTrainer", cascade = CascadeType.ALL)//quan hệ 1-n với đối tượng ở dưới: 1 PT có thể quản lý nhiều class.
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Class> classes;
}
