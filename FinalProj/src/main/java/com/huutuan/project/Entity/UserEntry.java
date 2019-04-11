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
@Table(name = "USER_ENTRY")
public class UserEntry {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "age")
	private int age;

	@OneToMany(mappedBy = "userentry")
	private Set<UserVideo> uservideo;

	@OneToMany(mappedBy = "imageentry")
	private Set<UserImage> userimage;

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
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the uservideo
	 */
	public Set<UserVideo> getUservideo() {
		return uservideo;
	}

	/**
	 * @param uservideo the uservideo to set
	 */
	public void setUservideo(Set<UserVideo> uservideo) {
		this.uservideo = uservideo;
	}

	/**
	 * @return the userimage
	 */
	public Set<UserImage> getUserimage() {
		return userimage;
	}

	/**
	 * @param userimage the userimage to set
	 */
	public void setUserimage(Set<UserImage> userimage) {
		this.userimage = userimage;
	}

}
