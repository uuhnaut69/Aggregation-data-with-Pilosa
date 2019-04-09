package com.huutuan.project.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huutuan.project.Entity.User;
import com.huutuan.project.Repository.UserRepository;

/**
 * @author uuhnaut
 *
 */
@RestController
public class UserControler {
	@Autowired
	private UserRepository userRepository;

	@GetMapping("/users")
	public List<User> showSignUpForm(User user) {
		Pageable pageable = PageRequest.of(0, 10);
		Page<User> pageUser = userRepository.findAll(pageable);
		List<User> list = pageUser.getContent();
		return list;
	}
}
