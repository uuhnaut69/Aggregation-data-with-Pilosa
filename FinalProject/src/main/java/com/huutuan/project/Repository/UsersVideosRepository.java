package com.huutuan.project.Repository;

import org.springframework.stereotype.Repository;

import com.huutuan.project.Entity.AjaxRespModel;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface UsersVideosRepository {

	public void doBenchMark(AjaxRespModel respModel);

	public void singleBenchMark(AjaxRespModel respModel, int id);
}
