package com.huutuan.project.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Image {
	@Id
	private int id;
	private String title;

	private String description;

	private String url;

	public Image() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Image(int id, String title, String description, String url) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.url = url;
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

	@Override
	public String toString() {
		return "Image{" + "id=" + id + ", title=" + title + ", description=" + description + ",url=" + url + '}';
	}
}
