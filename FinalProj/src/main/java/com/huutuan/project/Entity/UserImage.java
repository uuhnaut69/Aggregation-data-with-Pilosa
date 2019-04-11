package com.huutuan.project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author uuhnaut
 *
 */
@Entity
@Table(name = "USER_IMAGE")
public class UserImage {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private UserEntry userentry;

	@ManyToOne
	@JoinColumn(name = "image_id", nullable = false)
	private ImageEntry imageentry;

	@Column(name = "likes")
	private int likes;
	@Column(name = "shares")
	private int shares;

	public UserImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserImage(int id, UserEntry userentry, ImageEntry imageentry, int likes, int shares) {
		super();
		this.id = id;
		this.userentry = userentry;
		this.imageentry = imageentry;
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
	 * @return the userentry
	 */
	public UserEntry getUserentry() {
		return userentry;
	}

	/**
	 * @param userentry the userentry to set
	 */
	public void setUserentry(UserEntry userentry) {
		this.userentry = userentry;
	}

	/**
	 * @return the imageentry
	 */
	public ImageEntry getImageentry() {
		return imageentry;
	}

	/**
	 * @param imageentry the imageentry to set
	 */
	public void setImageentry(ImageEntry imageentry) {
		this.imageentry = imageentry;
	}

	/**
	 * @return the likes
	 */
	public int getLikes() {
		return likes;
	}

	/**
	 * @param likes the likes to set
	 */
	public void setLikes(int likes) {
		this.likes = likes;
	}

	/**
	 * @return the shares
	 */
	public int getShares() {
		return shares;
	}

	/**
	 * @param shares the shares to set
	 */
	public void setShares(int shares) {
		this.shares = shares;
	}

}
