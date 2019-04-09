package com.huutuan.project.Repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.huutuan.project.Entity.User;

/**
 * @author uuhnaut
 *
 */
@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	Page<User> findAll(Pageable pageable);

}