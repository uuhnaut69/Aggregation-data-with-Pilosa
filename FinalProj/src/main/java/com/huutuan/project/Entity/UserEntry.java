package com.huutuan.project.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author uuhnaut
 *
 */
@Entity
@Table(name = "USER_ENTRY")
public class UserEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	@Column(name = "uuid")
	private int uuid;
	@Column(name = "name")
	private String name;
	@Column(name = "created_utc")
	private int createdDate;
	@Column(name = "updated_on")
	private int updatedDate;
	@Column(name = "comment_karma")
	private int commentKarma;
	@Column(name = "link_karma")
	private int linkKarma;

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
	 * @return the uuid
	 */
	public int getUuid() {
		return uuid;
	}

	/**
	 * @param uuid the uuid to set
	 */
	public void setUuid(int uuid) {
		this.uuid = uuid;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the createdDate
	 */
	public int getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(int createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedDate
	 */
	public int getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate the updatedDate to set
	 */
	public void setUpdatedDate(int updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the commentKarma
	 */
	public int getCommentKarma() {
		return commentKarma;
	}

	/**
	 * @param commentKarma the commentKarma to set
	 */
	public void setCommentKarma(int commentKarma) {
		this.commentKarma = commentKarma;
	}

	/**
	 * @return the linkKarma
	 */
	public int getLinkKarma() {
		return linkKarma;
	}

	/**
	 * @param linkKarma the linkKarma to set
	 */
	public void setLinkKarma(int linkKarma) {
		this.linkKarma = linkKarma;
	}

}
