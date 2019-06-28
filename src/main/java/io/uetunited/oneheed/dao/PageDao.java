package io.uetunited.oneheed.dao;

import com.aventrix.jnanoid.jnanoid.NanoIdUtils;
import io.uetunited.oneheed.payload.dto.Page;
import org.apache.commons.lang3.StringUtils;
import org.jdbi.v3.core.Handle;
import org.jdbi.v3.core.Jdbi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PageDao {
    @Autowired
    Jdbi jdbi = null;

    public Optional<Page> getById(String pageId) {
        String sql = "select * from pages where id=:id";
        try (Handle handle = jdbi.open()) {
            return handle.createQuery(sql).bind("id", pageId).mapToBean(Page.class).findFirst();
        }
    }

    public Optional<Page> getBySocialId(String socialId, String type) {
        String sql = "select * from pages where social_id=:socialId and \"type\"=:type";
        try (Handle handle = jdbi.open()) {
            return handle.createQuery(sql).bind("socialId", socialId).bind("type", type).mapToBean(Page.class).findFirst();
        }
    }

    public Optional<Page> createPage(String id, String socialId, String name, String avatar, String accessToken, String type, boolean isActive) {
        String sql = "insert into pages(id, social_id, name, avatar, access_token, \"type\", is_Active) values " +
                "(:id, :socialId, :name, :avatar, :accessToken, :type, :isActive) on conflict (social_id, \"type\") do update set access_token = EXCLUDED.access_token";
        try (Handle handle = jdbi.open()) {
            return handle.createUpdate(sql)
                    .bind("id", id).bind("socialId", socialId).bind("name", name)
                    .bind("avatar", avatar).bind("accessToken", accessToken).bind("type", type).bind("isActive", isActive)
                    .executeAndReturnGeneratedKeys().mapToBean(Page.class).findFirst();
        }
    }

    public Optional<Page> createOrUpdatePageAccessToken(Page page) {
        if (StringUtils.isBlank(page.getId())) {
            page.setId(NanoIdUtils.randomNanoId());
        }
        return createPage(page.getId(), page.getSocialId(), page.getName(), page.getAvatar(), page.getAccessToken(), page.getType(), page.getIsActive());
    }
}
