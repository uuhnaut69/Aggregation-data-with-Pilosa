package com.huutuan.project.Entity;

public class ImageInfo {
	private int image_id;
	private String title;
	private String description;
	private String url;
	private long totalLikes;
	private long totalShares;

	public ImageInfo() {
	}

	public ImageInfo(int image_id, String title, String description, String url, long totalLikes, long totalShares) {
		super();
		this.image_id = image_id;
		this.title = title;
		this.description = description;
		this.url = url;
		this.totalLikes = totalLikes;
		this.totalShares = totalShares;
	}

	/**
	 * @return the image_id
	 */
	public int getImage_id() {
		return image_id;
	}

	/**
	 * @param image_id the image_id to set
	 */
	public void setImage_id(int image_id) {
		this.image_id = image_id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the totalLikes
	 */
	public long getTotalLikes() {
		return totalLikes;
	}

	/**
	 * @param totalLikes the totalLikes to set
	 */
	public void setTotalLikes(long totalLikes) {
		this.totalLikes = totalLikes;
	}

	/**
	 * @return the totalShares
	 */
	public long getTotalShares() {
		return totalShares;
	}

	/**
	 * @param totalShares the totalShares to set
	 */
	public void setTotalShares(long totalShares) {
		this.totalShares = totalShares;
	}

}
