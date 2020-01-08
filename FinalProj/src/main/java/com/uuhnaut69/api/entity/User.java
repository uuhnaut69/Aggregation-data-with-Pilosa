package com.uuhnaut69.api.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

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
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private int createdDate;

	private int updatedDate;

	private int commentKarma;

	private int linkKarma;

	@OneToMany
	@JoinColumn(name = "user_id")
	private List<UserImage> userImage = new ArrayList<>();

}
