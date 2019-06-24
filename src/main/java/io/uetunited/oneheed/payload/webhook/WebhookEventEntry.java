package io.uetunited.oneheed.payload.webhook;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class WebhookEventEntry {
	private String id;
	private Long time;
	private List<Messaging> messaging;

	@Override
	public String toString() {
		return "WebhookEventEntry [messaging=" + messaging + "]";
	}
}
