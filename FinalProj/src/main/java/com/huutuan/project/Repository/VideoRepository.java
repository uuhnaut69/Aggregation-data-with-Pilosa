package com.huutuan.project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.huutuan.project.Entity.VideoEntry;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface VideoRepository extends PagingAndSortingRepository<VideoEntry, Long> {
	Page<VideoEntry> findAll(Pageable pageable);
}
