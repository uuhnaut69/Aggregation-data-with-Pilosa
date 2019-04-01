package com.huutuan.project.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huutuan.project.Entity.AjaxRespModel;

/**
 * @author uuhnaut
 *
 */
@Repository
public class UsersVideosRepositoryImpl implements UsersVideosRepository {
	@Autowired
	EntityManager entityManager;

	@Override
	public void doBenchMark(AjaxRespModel respModel) {
		try {
			Long startTime = new DateTime().getMillis();
			String sql = "SELECT videoId, SUM(likes), SUM(shares) FROM users_videos GROUP BY videoId";
			List<?> list = entityManager.createNativeQuery(sql).getResultList();
			Long endTime = new DateTime().getMillis();
			Long runTime = endTime - startTime;
			respModel.setList(list);
			respModel.setQueryTime(runTime);
			System.out.println(respModel);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	public void singleBenchMark(AjaxRespModel respModel, int id) {
		try {
			Long startTime = new DateTime().getMillis();
			String sql = "SELECT videoId, SUM(likes), SUM(shares) FROM users_videos WHERE videoId = ?";
			List<?> list = entityManager.createNativeQuery(sql).setParameter(1, id).getResultList();
			Long endTime = new DateTime().getMillis();
			Long runTime = endTime - startTime;
			respModel.setList(list);
			respModel.setQueryTime(runTime);
			System.out.println(respModel);
		} catch (Exception e) {
			throw e;
		}
	}

}
