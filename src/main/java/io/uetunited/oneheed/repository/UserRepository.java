package io.uetunited.oneheed.repository;

import io.uetunited.oneheed.constant.UserType;
import io.uetunited.oneheed.payload.UserDTO;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import static io.uetunited.oneheed.entity.public_.tables.Users.USERS;


@Repository
public class UserRepository {
    final DSLContext context;

    @Autowired
    public UserRepository(DSLContext context) {
        this.context = context;
    }

    public UserDTO getById(String id) {
        UserDTO result = context.selectFrom(USERS).where(USERS.ID.eq(id)).fetchOne().into(UserDTO.class);
        return result;
    }

    public UserDTO getBySocialId(String socialId, UserType type) {
        UserDTO result = context.selectFrom(USERS).where(USERS.SOCIAL_ID.eq(socialId), USERS.TYPE.eq(type.name())).fetchOne().into(UserDTO.class);
        return result;
    }

    public UserDTO getByUsername(String username) {
        UserDTO result = context.selectFrom(USERS).where(USERS.USER_NAME.eq(username)).fetchOne().into(UserDTO.class);
        return result;
    }

    public boolean checkIfUserExists(String socialId, UserType type) {
        int count = context.selectCount().from(USERS).where(USERS.SOCIAL_ID.eq(socialId), USERS.TYPE.eq(type.name())).fetchOne(0, int.class);
        return count > 0;
    }
}
