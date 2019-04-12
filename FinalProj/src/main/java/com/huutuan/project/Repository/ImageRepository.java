package com.huutuan.project.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Query(value = "SELECT IMAGE_ENTRY.image_id, IMAGE_ENTRY.title, IMAGE_ENTRY.description, IMAGE_ENTRY.url, SUM(USER_IMAGE.likes), SUM(USER_IMAGE.shares) FROM IMAGE_ENTRY LEFT JOIN USER_IMAGE ON USER_IMAGE.image_id = IMAGE_ENTRY.image_id GROUP BY IMAGE_ENTRY.image_id", countQuery = "SELECT count(*) FROM IMAGE_ENTRY", nativeQuery = true)
	Page<Object[]> getData(Pageable pageable);

	@Query(value = "SELECT IMAGE_ENTRY.image_id, IMAGE_ENTRY.title, IMAGE_ENTRY.description, IMAGE_ENTRY.url, SUM(USER_IMAGE.likes), SUM(USER_IMAGE.shares) FROM IMAGE_ENTRY LEFT JOIN USER_IMAGE ON USER_IMAGE.image_id = IMAGE_ENTRY.image_id WHERE USER_IMAGE.image_id = :id", nativeQuery = true)
	List<Object[]> getOne(@Param("id") int id);
}
