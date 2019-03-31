package com.huutuan.project.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.huutuan.project.Entity.LikeShare;

@Repository
public class UsersImagesRepositoryImpl implements UsersImagesRepository {

	@Autowired
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<LikeShare> doBenchMark() {
		try {
			String sql = "SELECT imageId, SUM(likes), SUM(shares) FROM users_images GROUP BY imageId ";
			List<LikeShare> list = entityManager.createQuery(sql).getResultList();
			return list;
		} catch (Exception e) {
			throw e;
		}
	}

}
