package io.uetunited.oneheed.payload.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class User {
    private String id;
    private String email;
    private String name;
    private String type;
    private String avatar;
    private String socialId;
    @JsonIgnore
    private Boolean isActive = true;
    @JsonIgnore
    private Timestamp createdAt;
    @JsonIgnore
    private Timestamp updatedAt;
    @JsonIgnore
    private String accessToken;
    private String username;
}
