package com.uuhnaut69.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uuhnaut69.api.entity.view.ImageView;

public interface ImageViewRepository extends JpaRepository<ImageView, Long> {

	List<ImageView> findAll();

}
