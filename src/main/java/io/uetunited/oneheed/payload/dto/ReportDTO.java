package io.uetunited.oneheed.payload.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.util.Date;

@Getter
@Setter
public class ReportDTO {
    @Column(name = "id")
    private String id;
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "created_by")
    private String createdBy;
    @Column(name = "created_at")
    private Date createdAt;
    @Column(name = "reason")
    private String reason;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "email")
    private String email;
}
