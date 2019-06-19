package io.uetunited.oneheed.repository;

import io.uetunited.oneheed.entity.Role;
import io.uetunited.oneheed.constant.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
