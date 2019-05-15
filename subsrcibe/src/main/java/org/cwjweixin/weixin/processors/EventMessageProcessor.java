package org.cwjweixin.weixin.processors;

import org.cwjweixin.weixin.domain.event.EventInMessage;

public interface EventMessageProcessor {
	void onMessage(EventInMessage msg);
}
