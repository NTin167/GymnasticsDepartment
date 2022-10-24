package com.gym.web.webappsv.payload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gym.web.webappsv.model.Subscribe;
import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CustomerResponse {
    private Long id;
    private String name;
    private String gender;
    private String address;
    private String email;
    private String identifyCard;
    private String dob;
    private String phoneNumber;

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
