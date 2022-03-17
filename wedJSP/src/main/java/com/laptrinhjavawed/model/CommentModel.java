package com.laptrinhjavawed.model;

public class CommentModel extends AbstractModel{
	private Long newsID;
	private Long userID;
	private String content;
	public Long getNewsID() {
		return newsID;
	}
	public void setNewsID(Long newsID) {
		this.newsID = newsID;
	}
	public Long getUserID() {
		return userID;
	}
	public void setUserID(Long userID) {
		this.userID = userID;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
