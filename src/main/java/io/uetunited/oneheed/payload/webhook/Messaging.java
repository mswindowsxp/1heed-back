package io.uetunited.oneheed.payload.webhook;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Messaging {

	private MessengerUser sender;
	private MessengerUser recipient;
	private Long timestamp;
	
	private Message message;
	private Delivery delivery;
	private Read read;
	private Postback postback;

	@Override
	public String toString() {
	    return ReflectionToStringBuilder.toString(this);
	}

}
