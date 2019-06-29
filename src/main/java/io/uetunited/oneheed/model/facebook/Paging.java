package io.uetunited.oneheed.model.facebook;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Paging {

    private Cursors cursors;

    @Getter
    @Setter
    public class Cursors {
        private String before;
        private String after;
    }

    private String previous;
    private String next;
}
