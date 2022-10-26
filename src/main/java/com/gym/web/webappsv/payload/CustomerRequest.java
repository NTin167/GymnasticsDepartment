package com.gym.web.webappsv.payload;

import com.gym.web.webappsv.model.Subscribe;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
public class CustomerRequest {
    private Long id;
    private String name;
    private String gender;
    private String address;
    private String email;
    private String identifyCard;
    private String dob;
    private String phoneNumber;

    private List<Subscribe> subscribes;
//    public List<Subscribe> getSubscribes() {
//        return subscribes == null ? null : new ArrayList<>(subscribes);
//    }
//    public void setSubscribe(List<Subscribe> subscribes) {
//        if(subscribes == null) {
//            this.subscribes = null;
//        }
//        else {
//            this.subscribes = Collections.unmodifiableList(subscribes);
//        }
//    }
}
