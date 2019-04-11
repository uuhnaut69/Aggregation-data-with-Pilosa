package com.huutuan.project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huutuan.project.Entity.ImageEntry;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface ImageRepository extends JpaRepository<ImageEntry, Long> {
	Page<ImageEntry> findAll(Pageable pageable);
}
