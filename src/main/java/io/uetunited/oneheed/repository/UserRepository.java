package io.uetunited.oneheed.repository;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import io.uetunited.oneheed.constant.UserType;
import io.uetunited.oneheed.entity.public_.tables.records.UsersRecord;
import io.uetunited.oneheed.payload.dto.UserDTO;
import org.apache.commons.lang3.StringUtils;
import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import static io.uetunited.oneheed.entity.public_.tables.Users.USERS;


@Repository
public class UserRepository {
    final DSLContext context;

    @Autowired
    public UserRepository(DSLContext context) {
        this.context = context;
    }

    public UserDTO getById(String id) {
        UserDTO result = context.selectFrom(USERS).where(USERS.ID.eq(id)).fetchOneInto(UserDTO.class);
        return result;
    }

    public UserDTO getBySocialId(String socialId, UserType type) {
        List<UserDTO> result = context.selectFrom(USERS).where(USERS.SOCIAL_ID.eq(socialId), USERS.TYPE.eq(type.name())).fetchInto(UserDTO.class);
        return result.size() > 0 ? result.get(0) : null;
    }

    public UserDTO getByUsername(String username) {
        UserDTO result = context.selectFrom(USERS).where(USERS.USERNAME.eq(username)).fetchOneInto(UserDTO.class);
        return result;
    }

    public UserDTO createOrUpdateUserAccessToken(UserDTO userDTO) {
        if (StringUtils.isBlank(userDTO.getId())) {
            userDTO.setId(NanoIdUtils.randomNanoId());
        }
        UsersRecord record = context.newRecord(USERS);
        record.setId(userDTO.getId());
        record.setCreatedAt(userDTO.getCreatedAt());
        record.setUpdatedAt(null);
        record.setEmail(userDTO.getEmail());
        record.setName(userDTO.getName());
        record.setType(userDTO.getType().name());
        record.setAvatar(userDTO.getAvatar());
        record.setSocialId(userDTO.getSocialId());
        record.setIsActive(userDTO.getIsActive());
        record.setAccessToken(userDTO.getAccessToken());
        record.setUsername(userDTO.getUsername());
        context.update(USERS).set(record);
        return userDTO;
    }

    public boolean checkIfUserExists(String socialId, UserType type) {
        int count = context.selectCount().from(USERS).where(USERS.SOCIAL_ID.eq(socialId), USERS.TYPE.eq(type.name())).fetchOne(0, int.class);
        return count > 0;
    }
}
