package io.uetunited.oneheed.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.uetunited.oneheed.constant.UserType;
import io.uetunited.oneheed.payload.dto.UserDTO;
import org.apache.logging.log4j.util.Strings;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserPrincipal implements UserDetails {
    private String id;

    private String name;

    private String socialId;

    private UserType userType;

    @JsonIgnore
    private String email;

    private String username;

    private String avatar;

    @JsonIgnore
    private String password;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(String id, String name, String socialId, UserType userType, String email, String username, String avatar, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.name = name;
        this.socialId = socialId;
        this.userType = userType;
        this.email = email;
        this.username = username;
        this.avatar = avatar;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(UserDTO user) {
        List<GrantedAuthority> authorities =
                Arrays.asList(new SimpleGrantedAuthority("USER"));

        return new UserPrincipal(
                user.getId(),
                user.getName(),
                user.getSocialId(),
                user.getType(),
                user.getEmail(),
                user.getSocialId(),
                user.getAvatar(),
                Strings.EMPTY,
                authorities
        );
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSocialId() {
        return socialId;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }
}
