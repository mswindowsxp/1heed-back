package io.uetunited.oneheed.payload;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class CustomerDTO {
    @Column(name = "id")
    private String id;
    @Column(name = "social_id")
    private String socialId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "address")
    private String address;
    @Column(name = "type")
    private String type;
}
