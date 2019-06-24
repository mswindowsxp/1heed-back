/**
 * 
 */
package io.uetunited.oneheed.payload;

import java.util.List;


/**
 * @author la-pc
 *
 */
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
	public List<WebhookEventEntry> getEntry() {
		return entry;
	}
	public void setEntry(List<WebhookEventEntry> entry) {
		this.entry = entry;
	}
	public String getObject() {
		return object;
	}
	public void setObject(String object) {
		this.object = object;
	}

	@Override
	public String toString() {
		return "WebhookEvent [entry=" + entry + ", object=" + object + "]";
	}  
}
