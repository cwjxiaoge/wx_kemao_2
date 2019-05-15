package org.cwjweixin.weixin.domain;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class InMessage implements Serializable {
	
	private static final long serialVersionUID = 1L;

	
	@XmlElement(name="ToUserName")
	@JsonProperty("ToUserName")
	private String toUserName;
	@XmlElement(name="FromUserName")
	@JsonProperty("FromUserName")
	private String fromUserName;
	@XmlElement(name="CreateTime")
	@JsonProperty("CreateTime")
	private long createTime;
	@XmlElement(name="MsgType")
	@JsonProperty("MsgType")
	private String msgType;
	@XmlElement(name="MygId")
	@JsonProperty("MygId")
	private long mygId;
	public String getToUserName() {
		return toUserName;
	}
	public void setToUserName(String toUserName) {
		this.toUserName = toUserName;
	}
	public String getFromUserName() {
		return fromUserName;
	}
	public void setFromUserName(String fromUserName) {
		this.fromUserName = fromUserName;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getMygType() {
		return msgType;
	}
	public void setMygType(String mygType) {
		this.msgType = mygType;
	}
	public long getMygId() {
		return mygId;
	}
	public void setMygId(long mygId) {
		this.mygId = mygId;
	}
	abstract public String toString();
}
