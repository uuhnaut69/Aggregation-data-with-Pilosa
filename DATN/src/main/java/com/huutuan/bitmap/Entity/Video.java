package com.huutuan.bitmap.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Video {
	@Id
	private int id;
	private String titleId;
	private int ordering;
	private String title;
	private String region;
	private String language;
	private String types;
	private String attributes;
	private boolean isOriginalTitle;

	public Video() {
	}

	public Video(int id, String titleId, int ordering, String title, String region, String language, String types,
			String attributes, boolean isOriginalTitle) {
		super();
		this.id = id;
		this.titleId = titleId;
		this.ordering = ordering;
		this.title = title;
		this.region = region;
		this.language = language;
		this.types = types;
		this.attributes = attributes;
		this.isOriginalTitle = isOriginalTitle;
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
	 * @return the titleId
	 */
	public String getTitleId() {
		return titleId;
	}

	/**
	 * @param titleId the titleId to set
	 */
	public void setTitleId(String titleId) {
		this.titleId = titleId;
	}

	/**
	 * @return the ordering
	 */
	public int getOrdering() {
		return ordering;
	}

	/**
	 * @param ordering the ordering to set
	 */
	public void setOrdering(int ordering) {
		this.ordering = ordering;
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
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}

	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @return the types
	 */
	public String getTypes() {
		return types;
	}

	/**
	 * @param types the types to set
	 */
	public void setTypes(String types) {
		this.types = types;
	}

	/**
	 * @return the attributes
	 */
	public String getAttributes() {
		return attributes;
	}

	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	/**
	 * @return the isOriginalTitle
	 */
	public boolean isOriginalTitle() {
		return isOriginalTitle;
	}

	/**
	 * @param isOriginalTitle the isOriginalTitle to set
	 */
	public void setOriginalTitle(boolean isOriginalTitle) {
		this.isOriginalTitle = isOriginalTitle;
	}

	@Override
	public String toString() {
		return "User{" + "id=" + id + ", titleId=" + titleId + ",ordering= " + ordering + ",title= " + title
				+ ",region= " + region + ",language= " + language + ",types= " + types + ",attributes =" + attributes
				+ ",isOriginalTitle= " + isOriginalTitle + "}";
	}

}
