package com.uuhnaut69.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uuhnaut69.api.entity.Image;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

}
