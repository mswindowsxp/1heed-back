package io.uetunited.oneheed.payload.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {
    private String id;
    private String socialId;
    private String name;
    private String email;
    private String phone;
    private String address;
    private String type;
}
