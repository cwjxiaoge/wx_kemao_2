package org.cwjweixin.weixin.domain.shortvideo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.cwjweixin.weixin.domain.InMessage;

import com.fasterxml.jackson.annotation.JsonProperty;



@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class ShortvideoInMessage extends InMessage {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name="MediaId")
	@JsonProperty("MediaId")
	private String mediaId;
	
	@XmlElement(name="ThumbMediaId")
	@JsonProperty("ThumbMediaId")
	private String thumbMediaId;

	public String getMediaId() {
		return mediaId;
	}

	public void setMediaId(String mediaId) {
		this.mediaId = mediaId;
	}

	public String getThumbMediaId() {
		return thumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		this.thumbMediaId = thumbMediaId;
	}

	@Override
	public String toString() {
		return "ShortvideoInMessage [mediaId=" + mediaId + ", thumbMediaId=" + thumbMediaId + ", getToUSerName()="
				+ getToUserName() + ", getFromUserName()=" + getFromUserName() + ", getCreateTime()=" + getCreateTime()
				+ ", getMygType()=" + getMygType() + ", getMygId()=" + getMygId() + "]";
	}
	
}
