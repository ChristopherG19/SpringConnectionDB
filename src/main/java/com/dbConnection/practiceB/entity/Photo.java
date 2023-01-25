package com.dbConnection.practiceB.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="PHOTO")
public class Photo implements Serializable{

	private static final long serialVersionUID = -5862808298390643349L;

	@Id
	@Column(name="PHOTOID")
	private int photoId;
	
	@Column(name = "DESCRIPTION")
	private String description;
	
	@Column(name = "URL")
	private String url;

	@Column(name = "USERID")
	private int userInsta;

	public int getPhotoId() {
		return photoId;
	}

	public void setPhotoId(int photoId) {
		this.photoId = photoId;
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

	public int getUserInsta() {
		return userInsta;
	}

	public void setUserInsta(int userInsta) {
		this.userInsta = userInsta;
	}
	
}
