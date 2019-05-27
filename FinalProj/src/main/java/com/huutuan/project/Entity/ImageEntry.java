package com.huutuan.project.Entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author uuhnaut
 *
 */
@Entity
@Table(name = "IMAGE_ENTRY")
public class ImageEntry {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "image_id")
	private int id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "url")
	private String url;

	@OneToMany(mappedBy = "imageEntry")
	private List<UserImageEntity> userImageEntity;

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

	/**
	 * @return the userImageEntity
	 */
	public List<UserImageEntity> getUserImageEntity() {
		return userImageEntity;
	}

	/**
	 * @param userImageEntity the userImageEntity to set
	 */
	public void setUserImageEntity(List<UserImageEntity> userImageEntity) {
		this.userImageEntity = userImageEntity;
	}

}
