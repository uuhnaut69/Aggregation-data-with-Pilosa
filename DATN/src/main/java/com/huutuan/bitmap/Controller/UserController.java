package com.huutuan.bitmap.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.huutuan.bitmap.DAO.UserDAO;
import com.huutuan.bitmap.Entity.SearchRespModel;
import com.huutuan.bitmap.Entity.User;
import com.huutuan.bitmap.Pilosa.StarTrace;
import com.huutuan.bitmap.Service.UserService;

/**
 * @author uuhnaut
 *
 */
@Controller
public class UserController {
	private final UserDAO userRepository;

	@Autowired
	public UserController(UserDAO userRepository) {
		this.userRepository = userRepository;
	}

	@Autowired
	private StarTrace starTrace;
	@Autowired
	private UserService userService;

	@GetMapping("/list-user")
	public String homePage(Model model, @RequestParam("pageNo") int pageNo, @RequestParam("pageSize") int pageSize) {
		SearchRespModel respModel = userService.getDataSearch(pageNo, pageSize);
		model.addAttribute("searchRespModel", respModel);
		List<User> listUser = respModel.getListUser();
		model.addAttribute("listUser", listUser);
		return "index";
	}

	@GetMapping("/signup")
	public String showSignUpForm(User user) {
		return "add-user";
	}

	@PostMapping("/adduser")
	public String addUser(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "add-user";
		}

		userRepository.save(user);
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("user", user);
		return "update-user";
	}

	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") int id, @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}

		userRepository.save(user);
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		userRepository.delete(user);
		model.addAttribute("users", userRepository.findAll());
		return "index";
	}

	@GetMapping("/pilosa")
	public String getData() {
		starTrace.getData();
		return "index";
	}
}
