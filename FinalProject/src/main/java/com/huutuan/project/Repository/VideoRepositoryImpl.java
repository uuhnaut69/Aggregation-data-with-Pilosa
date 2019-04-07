package com.huutuan.project.Repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author uuhnaut
 *
 */
@Repository
public class VideoRepositoryImpl implements VideoRepository {
	@Autowired
	EntityManager entityManager;

	@Override
	public List<?> getData() {
		try {
			String sql = "SELECT video.id,video.title,  video.url,SUM(likes), SUM(shares) FROM video left join users_videos on users_videos.videoId = video.id group by video.id;";
			List<?> list = entityManager.createNativeQuery(sql).getResultList();
			return list;
		} catch (Exception e) {
			throw e;
		}
	}

}
