package org.cwjweixin.weixin.domain.link;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.cwjweixin.weixin.domain.InMessage;

import com.fasterxml.jackson.annotation.JsonProperty;


@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class LinkInMessage extends InMessage {

	private static final long serialVersionUID = 1L;

	
	@XmlElement(name="Title")
	@JsonProperty("Title")
	private String title;
	
	@XmlElement(name="Description")
	@JsonProperty("Description")
	private String description;
	
	@XmlElement(name="Url")
	@JsonProperty("Url")
	private String url;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "LinkInMessage [title=" + title + ", description=" + description + ", url=" + url + ", getToUSerName()="
				+ getToUserName() + ", getFromUserName()=" + getFromUserName() + ", getCreateTime()=" + getCreateTime()
				+ ", getMygType()=" + getMygType() + ", getMygId()=" + getMygId() + "]";
	}
	
	
}
