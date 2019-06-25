/**
 *
 */
package io.uetunited.oneheed.payload.webhook;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


/**
 * @author la-pc
 *
 */
@Getter
@Setter
@ToString
public class WebhookEvent {
    private List<WebhookEventEntry> entry;
    private String object;

    public WebhookEvent() {
    }

    public WebhookEvent(List<WebhookEventEntry> entry, String object) {
        super();
        this.entry = entry;
        this.object = object;
    }


}
