package org.cwjweixin.weixin.domain.voice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.cwjweixin.weixin.domain.InMessage;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class VoiceInMessage extends InMessage{
	private static final long serialVersionUID = 1L;
	
	
	@XmlElement(name="MediaId")
	@JsonProperty("MediaId")
	private String mediaId;
	
	@XmlElement(name="Format")
	@JsonProperty("Format")
	private String format;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public String toString() {
		return "VoiceInMessage [mediaId=" + mediaId + ", format=" + format + ", getToUSerName()=" + getToUserName()
				+ ", getFromUserName()=" + getFromUserName() + ", getCreateTime()=" + getCreateTime()
				+ ", getMygType()=" + getMygType() + ", getMygId()=" + getMygId() + "]";
	}
	
}
