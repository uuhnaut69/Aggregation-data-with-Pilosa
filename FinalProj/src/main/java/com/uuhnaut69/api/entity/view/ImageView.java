package com.uuhnaut69.api.entity.view;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author uuhnaut
 *
 */
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class ImageView {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;

	private String description;

	private String url;

	private long totalLikes;

	private long totalShares;

}
