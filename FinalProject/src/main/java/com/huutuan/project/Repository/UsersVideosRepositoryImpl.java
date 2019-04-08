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
	@SuppressWarnings("unchecked")
	public void doBenchMark(AjaxRespModel respModel) {
		try {
			Long startTime = new DateTime().getMillis();
			String sql = "SELECT video.title, SUM(likes), SUM(shares) FROM video left join users_videos on users_videos.videoId = video.id group by video.id";
			List<Object[]> list = entityManager.createNativeQuery(sql).getResultList();
			Long endTime = new DateTime().getMillis();
			Long runTime = endTime - startTime;
			respModel.setList(list);
			respModel.setMySqlQueryTime(runTime);
			System.out.println(respModel);
		} catch (Exception e) {
			throw e;
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public void singleBenchMark(AjaxRespModel respModel, int id) {
		try {
			Long startTime = new DateTime().getMillis();
			String sql = "SELECT video.title, SUM(likes), SUM(shares) FROM video left join users_videos on users_videos.videoId = video.id WHERE users_videos.videoId = ?";
			List<Object[]> list = entityManager.createNativeQuery(sql).setParameter(1, id).getResultList();
			Long endTime = new DateTime().getMillis();
			Long runTime = endTime - startTime;
			respModel.setList(list);
			respModel.setMySqlQueryTime(runTime);
			System.out.println(respModel);
		} catch (Exception e) {
			throw e;
		}
	}

}
