package io.uetunited.oneheed.payload;

import io.uetunited.oneheed.constant.RoleName;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
public class RoleDTO {
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private RoleName name;
}
