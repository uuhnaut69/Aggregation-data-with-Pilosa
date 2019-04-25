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
public class UserImageEnity {
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

	@Column(name = "likes")
	private long likes;
	@Column(name = "shares")
	private long shares;

	public UserImageEnity() {
	}

	public UserImageEnity(int id, UserEntry userEntry, ImageEntry imageEntry, long likes, long shares) {
		super();
		this.id = id;
		this.userEntry = userEntry;
		this.imageEntry = imageEntry;
		this.likes = likes;
		this.shares = shares;
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
	 * @return the likes
	 */
	public long getLikes() {
		return likes;
	}

	/**
	 * @param likes the likes to set
	 */
	public void setLikes(long likes) {
		this.likes = likes;
	}

	/**
	 * @return the shares
	 */
	public long getShares() {
		return shares;
	}

	/**
	 * @param shares the shares to set
	 */
	public void setShares(long shares) {
		this.shares = shares;
	}

}
