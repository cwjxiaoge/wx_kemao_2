package org.cwjweixin.weixin.service;

import java.io.StringReader;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.xml.bind.JAXB;

import org.cwjweixin.weixin.domain.InMessage;
import org.cwjweixin.weixin.domain.event.EventInMessage;
import org.cwjweixin.weixin.domain.image.ImageInMessage;
import org.cwjweixin.weixin.domain.link.LinkInMessage;
import org.cwjweixin.weixin.domain.location.LocationInMessage;
import org.cwjweixin.weixin.domain.shortvideo.ShortvideoInMessage;
import org.cwjweixin.weixin.domain.text.TextInMessage;
import org.cwjweixin.weixin.domain.video.VideoInMessage;
import org.cwjweixin.weixin.domain.voice.VoiceInMessage;

public class MessageConvertHelper {
	
	// 1.使用一个Map来记录消息类型和Java类型的关系
	private static final Map<String,Class<? extends InMessage>> typeMap =new ConcurrentHashMap<>();
	static {
		typeMap.put("text", TextInMessage.class);
		typeMap.put("image", ImageInMessage.class);
		typeMap.put("vioce", VoiceInMessage.class);
		typeMap.put("video", VideoInMessage.class);
		typeMap.put("location", LocationInMessage.class);
		typeMap.put("event", EventInMessage.class);
		typeMap.put("link", LinkInMessage.class);
		typeMap.put("shortvideo", ShortvideoInMessage.class);
	}
	
	public static Class<? extends InMessage> getClass(String xml) {
		// 获取类型
		String type = xml.substring(xml.indexOf("<MsgType><![CDATA[") + 18);
		type = type.substring(0, type.indexOf("]"));

		// 获取Java类
		Class<? extends InMessage> c = typeMap.get(type);
		return c;
	}
	
	
	// 2.提供一个静态的方法，可以传入XML，把XML转换为Java对象
	public static <T extends InMessage> T convert(String xml) {
		
		// 获取类型
		String type=xml.substring(xml.indexOf("<MsgType><![CDATA[")+18);
		type=type.substring(0,type.indexOf("]"));
		
		// 获取Java类
		Class<? extends InMessage> c=typeMap.get(type);
		if(c==null) {
			return null;
		}
		// 使用JAXB转换
		@SuppressWarnings("unchecked")
		T msg =(T) JAXB.unmarshal(new StringReader(xml),c);
		return msg;
		}
}
