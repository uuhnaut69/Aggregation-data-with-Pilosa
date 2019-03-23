package com.huutuan.bitmap.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.huutuan.bitmap.Entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	List<User> findByName(String name);
}