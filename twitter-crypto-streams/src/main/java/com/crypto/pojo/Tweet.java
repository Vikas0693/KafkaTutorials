package com.crypto.pojo;

public class Tweet {
	private Long createdAt;
	private Long id;
	private String lang;
	private Boolean retweet;
	private String text;
	public Long getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public Boolean getRetweet() {
		return retweet;
	}
	public void setRetweet(Boolean retweet) {
		this.retweet = retweet;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	@Override
	public String toString() {
		return "Tweet [createdAt=" + createdAt + ", id=" + id + ", lang=" + lang + ", retweet=" + retweet + ", text="
				+ text + "]";
	}
	
}
