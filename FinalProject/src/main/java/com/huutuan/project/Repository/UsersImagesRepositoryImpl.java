package com.huutuan.project.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huutuan.project.Entity.AjaxRespModel;
import com.huutuan.project.Entity.LikeShare;

/**
 * @author uuhnaut
 *
 */
@Repository
public class UsersImagesRepositoryImpl implements UsersImagesRepository {

	@Autowired
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public AjaxRespModel doBenchMark() {
		try {
			AjaxRespModel respModel = new AjaxRespModel();
			Long startTime = new DateTime().getMillis();
			String sql = "SELECT a.imageId, SUM(a.likes), SUM(a.shares) FROM users_images a GROUP BY a.imageId";
			List<LikeShare> list = entityManager.createNativeQuery(sql).getResultList();
			Long endTime = new DateTime().getMillis();
			Long runTime = endTime - startTime;
			respModel.setList(list);
			respModel.setQueryTime(runTime);
			System.out.println(respModel);
			return respModel;
		} catch (Exception e) {
			throw e;
		}
	}

}
