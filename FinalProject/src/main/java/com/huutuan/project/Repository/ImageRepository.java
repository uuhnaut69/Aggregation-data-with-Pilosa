package com.huutuan.project.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface ImageRepository {
	public List<?> getData();
}
