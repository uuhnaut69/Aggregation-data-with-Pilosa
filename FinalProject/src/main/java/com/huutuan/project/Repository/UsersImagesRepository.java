package com.huutuan.project.Repository;

import org.springframework.stereotype.Repository;

import com.huutuan.project.Entity.AjaxRespModel;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface UsersImagesRepository {

	AjaxRespModel doBenchMark();
}
