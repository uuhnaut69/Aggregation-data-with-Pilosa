package com.huutuan.bitmap.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.huutuan.bitmap.Entity.Video;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface VideoRepository extends PagingAndSortingRepository<Video, Integer> {
	Page<Video> findAll(Pageable pageable);
}