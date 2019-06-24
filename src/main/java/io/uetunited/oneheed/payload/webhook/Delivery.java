package io.uetunited.oneheed.payload.webhook;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Delivery {
    private List<String> mids;
    private Long watermark;
    private Long seq;
}
