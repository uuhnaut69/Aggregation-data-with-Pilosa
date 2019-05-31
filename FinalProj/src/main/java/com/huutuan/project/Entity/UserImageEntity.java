package com.huutuan.project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "USER_IMAGE")
public class UserImageEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntry userEntry;

	@ManyToOne
	@JoinColumn(name = "image_id")
	private ImageEntry imageEntry;

	@Column(name = "liked")
	private boolean liked;
	@Column(name = "shared")
	private boolean shared;

	public UserImageEntity() {
	}

	public UserImageEntity(int id, UserEntry userEntry, ImageEntry imageEntry, boolean liked, boolean shared) {
		this.id = id;
		this.userEntry = userEntry;
		this.imageEntry = imageEntry;
		this.liked = liked;
		this.shared = shared;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the userEntry
	 */
	public UserEntry getUserEntry() {
		return userEntry;
	}

	/**
	 * @param userEntry the userEntry to set
	 */
	public void setUserEntry(UserEntry userEntry) {
		this.userEntry = userEntry;
	}

	/**
	 * @return the imageEntry
	 */
	public ImageEntry getImageEntry() {
		return imageEntry;
	}

	/**
	 * @param imageEntry the imageEntry to set
	 */
	public void setImageEntry(ImageEntry imageEntry) {
		this.imageEntry = imageEntry;
	}

	/**
	 * @return the liked
	 */
	public boolean isLiked() {
		return liked;
	}

	/**
	 * @param liked the liked to set
	 */
	public void setLiked(boolean liked) {
		this.liked = liked;
	}

	/**
	 * @return the shared
	 */
	public boolean isShared() {
		return shared;
	}

	/**
	 * @param shared the shared to set
	 */
	public void setShared(boolean shared) {
		this.shared = shared;
	}

}
