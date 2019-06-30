package io.uetunited.oneheed.model.facebook;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Picture {
    private Data data;
    private String id;

    @JsonIgnoreProperties(ignoreUnknown = true)
    @Getter
    @Setter
    public class Data {
        private int height;
        private int width;
        private String url;

    }

}