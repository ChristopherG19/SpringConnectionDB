package com.dbConnection.practiceB.entity;

import java.io.Serializable;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID")
	@JsonIgnoreProperties
	@NotFound(action = NotFoundAction.IGNORE)
	private UserInsta userInsta;
	
	public UserInsta getUserInsta() {
		return userInsta;
	}

	public void setUserInsta(UserInsta userInsta) {
		this.userInsta = userInsta;
	}

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

}
