package com.huutuan.project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.huutuan.project.Entity.VideoEntry;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface VideoRepository extends JpaRepository<VideoEntry, Long> {
	Page<VideoEntry> findAll(Pageable pageable);

	@Query(value = "SELECT VIDEO_ENTRY.video_id, VIDEO_ENTRY.title,  VIDEO_ENTRY.url, SUM(USER_VIDEO.likes) as totalLikes, SUM(USER_VIDEO.shares) as totalShares FROM VIDEO_ENTRY LEFT JOIN USER_VIDEO ON USER_VIDEO.video_id = VIDEO_ENTRY.video_id GROUP BY VIDEO_ENTRY.video_id", nativeQuery = true)
	Page<Object[]> getData(Pageable pageable);
}
