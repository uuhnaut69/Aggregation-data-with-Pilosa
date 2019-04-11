package com.huutuan.project.Entity;

import java.util.Set;

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
@Table(name = "VIDEO_ENTRY")
public class VideoEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "video_id")
	private int id;
	@Column(name = "url")
	private String url;
	@Column(name = "title")
	private String title;

	@OneToMany(mappedBy = "videoentry")
	private Set<UserVideo> userVideo;

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
	 * @return the userVideo
	 */
	public Set<UserVideo> getUserVideo() {
		return userVideo;
	}

	/**
	 * @param userVideo the userVideo to set
	 */
	public void setUserVideo(Set<UserVideo> userVideo) {
		this.userVideo = userVideo;
	}

}
