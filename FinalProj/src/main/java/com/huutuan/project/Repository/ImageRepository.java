package com.huutuan.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.huutuan.project.Entity.ImageEntry;
import com.huutuan.project.Entity.ImageInfo;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface ImageRepository extends JpaRepository<ImageEntry, Long> {

	@Query(value = "SELECT new com.huutuan.project.Entity.ImageInfo(a.id, a.title, a.description, a.url, SUM(b.likes), SUM(b.shares)) FROM ImageEntry a LEFT JOIN a.userImageEntity b ON b.imageEntry.id = a.id WHERE b.imageEntry.id = :id")
	ImageInfo getImageInfoById(@Param("id") int id);

	@Query(value = "SELECT new com.huutuan.project.Entity.ImageInfo(a.id, a.title, a.description, a.url, SUM(b.likes), SUM(b.shares)) FROM ImageEntry a LEFT JOIN a.userImageEntity b ON b.imageEntry.id = a.id GROUP BY a.id")
	List<ImageInfo> getImagesInfo();

	ImageEntry findById(int id);
}
