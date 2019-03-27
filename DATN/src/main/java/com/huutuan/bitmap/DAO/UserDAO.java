package com.huutuan.bitmap.DAO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.huutuan.bitmap.Entity.User;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface UserDAO extends PagingAndSortingRepository<User, Integer> {
	Page<User> findAll(Pageable pageable);
}