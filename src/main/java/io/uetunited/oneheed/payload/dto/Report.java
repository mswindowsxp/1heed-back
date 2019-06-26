package io.uetunited.oneheed.payload.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Report {
    private String id;
    private String customerId;
    private String createdBy;
    private Date createdAt;
    private String reason;
    private String phone;
    private String address;
    private String email;
}
