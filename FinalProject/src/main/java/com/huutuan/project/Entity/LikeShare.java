package com.huutuan.project.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class LikeShare {

	@Id
	private int id;
	private int imageId;
	private int totalLikes;
	private int totalShares;

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
	 * @return the imageId
	 */
	public int getImageId() {
		return imageId;
	}

	/**
	 * @param imageId the imageId to set
	 */
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}

	/**
	 * @return the totalLikes
	 */
	public int getTotalLikes() {
		return totalLikes;
	}

	/**
	 * @param totalLikes the totalLikes to set
	 */
	public void setTotalLikes(int totalLikes) {
		this.totalLikes = totalLikes;
	}

	/**
	 * @return the totalShares
	 */
	public int getTotalShares() {
		return totalShares;
	}

	/**
	 * @param totalShares the totalShares to set
	 */
	public void setTotalShares(int totalShares) {
		this.totalShares = totalShares;
	}

}
