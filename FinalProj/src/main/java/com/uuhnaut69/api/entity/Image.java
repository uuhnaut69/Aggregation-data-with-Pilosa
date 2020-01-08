package com.uuhnaut69.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * @author uuhnaut
 *
 */
@Data
@Entity
public class Image {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;

	private String url;

	@OneToMany
	@JoinColumn(name = "image_id")
	private List<UserImage> userImage = new ArrayList<>();

}
