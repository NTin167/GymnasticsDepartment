package com.gym.web.webappsv.payload;

import lombok.Data;

@Data
public class SubscribeRequest {
    private Long id;
    private int status;
    private Long customerId;
    private Long userId;
    private Long classId;
}
