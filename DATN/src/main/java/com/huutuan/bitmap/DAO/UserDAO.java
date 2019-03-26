package com.huutuan.bitmap.DAO;

import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.huutuan.bitmap.Entity.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer> {
	Page<User> findAll(Pageable pageable);
}