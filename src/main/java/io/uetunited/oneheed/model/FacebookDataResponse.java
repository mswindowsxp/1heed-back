package io.uetunited.oneheed.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class FacebookDataResponse<T> {
    private List<T> data;
    private Paging paging;
}
