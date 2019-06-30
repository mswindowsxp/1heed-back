package io.uetunited.oneheed.model.facebook;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FacebookDataObject<T> {
    private List<T> data;
    private Paging paging;
}
