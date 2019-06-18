package io.uetunited.oneheed.payload;

import java.util.List;

public class WebhookEventEntry {
	List<Messaging> messaging;

	public List<Messaging> getMessaging() {
		return messaging;
	}

	public void setMessaging(List<Messaging> messaging) {
		this.messaging = messaging;
	}

	@Override
	public String toString() {
		return "WebhookEventEntry [messaging=" + messaging + "]";
	}
}
