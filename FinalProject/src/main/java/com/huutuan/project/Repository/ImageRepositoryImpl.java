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
public class ImageRepositoryImpl implements ImageRepository {
	@Autowired
	EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Object[]> getData() {
		try {
			String sql = "SELECT image.id,image.title, image.description, image.url,SUM(likes),SUM(shares) FROM image left join users_images on users_images.imageId = image.id group by image.id";
			List<Object[]> list = entityManager.createNativeQuery(sql).getResultList();
			return list;
		} catch (Exception e) {
			throw e;
		}
	}

}
