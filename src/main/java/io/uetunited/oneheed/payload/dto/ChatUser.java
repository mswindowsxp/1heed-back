package io.uetunited.oneheed.payload.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatUser {
    private String id;
    private String socialId;
    private String name;
    private String email;
    private String type; // UserType


    // capture from user chat message
    private String phone;
    private String address;
}
