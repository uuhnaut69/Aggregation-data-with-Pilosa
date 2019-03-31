package com.huutuan.project.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.huutuan.project.Entity.LikeShare;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface UsersImagesRepository {

	List<LikeShare> doBenchMark();
}
