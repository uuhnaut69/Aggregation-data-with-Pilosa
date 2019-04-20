package com.huutuan.project.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.huutuan.project.Entity.ImageEntry;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface ImageRepository extends JpaRepository<ImageEntry, Long> {

	@Query(value = "SELECT IMAGE_ENTRY.image_id, IMAGE_ENTRY.title, IMAGE_ENTRY.description, IMAGE_ENTRY.url, SUM(USER_IMAGE_BACKUP.likes), SUM(USER_IMAGE_BACKUP.shares) FROM IMAGE_ENTRY LEFT JOIN USER_IMAGE_BACKUP ON USER_IMAGE_BACKUP.image_id = IMAGE_ENTRY.image_id GROUP BY IMAGE_ENTRY.image_id", nativeQuery = true)
	List<Object[]> getData();

	@Query(value = "SELECT IMAGE_ENTRY.image_id, IMAGE_ENTRY.title, IMAGE_ENTRY.description, IMAGE_ENTRY.url, SUM(USER_IMAGE_BACKUP.likes), SUM(USER_IMAGE_BACKUP.shares) FROM IMAGE_ENTRY LEFT JOIN USER_IMAGE_BACKUP ON USER_IMAGE_BACKUP.image_id = IMAGE_ENTRY.image_id WHERE USER_IMAGE_BACKUP.image_id = :id", nativeQuery = true)
	List<Object[]> getOne(@Param("id") int id);
}
