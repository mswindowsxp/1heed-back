package io.uetunited.oneheed.model.facebook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class PageAccount {
    private String name;
    private String id;
    private Picture picture;
}
