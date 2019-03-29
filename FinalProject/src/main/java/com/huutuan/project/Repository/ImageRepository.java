package com.huutuan.project.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.huutuan.project.Entity.Image;

@Repository
public interface ImageRepository extends CrudRepository<Image, Long> {
	List<Image> findByTitle(String title);
}
