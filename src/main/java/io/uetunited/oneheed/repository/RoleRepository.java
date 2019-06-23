package io.uetunited.oneheed.repository;

import io.uetunited.oneheed.constant.RoleName;
import io.uetunited.oneheed.payload.RoleDTO;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static io.uetunited.oneheed.entity.public_.tables.Roles.ROLES;


@Repository
public class RoleRepository {
    final DSLContext context;

    @Autowired
    public RoleRepository(DSLContext context) {
        this.context = context;
    }

    public RoleDTO getByName(RoleName roleName) {
        RoleDTO result = context.selectFrom(ROLES).where(ROLES.NAME.equalIgnoreCase(roleName.name())).fetchOne().into(RoleDTO.class);
        return result;
    }

    public RoleDTO getById(Long id) {
        RoleDTO result = context.selectFrom(ROLES).where(ROLES.ID.eq(id)).fetchOne().into(RoleDTO.class);
        return result;
    }
}
