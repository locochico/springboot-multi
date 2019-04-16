package com.skmns.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skmns.api.service.UserService;
import com.skmns.common.model.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping
	public String getUsers(Model model) {
		
		List<User> users = userService.getAllUser();
		
		log.trace("doStuff needed more information - {}", users);
		log.debug("doStuff needed to debug - {}", users);
		log.info("doStuff took input - {}", users);
		log.warn("doStuff needed to warn - {}", users);
		log.error("doStuff encountered an error with value - {}", users);
		
		model.addAttribute("users", users);
		return "users/list";
	}

	@GetMapping("{id}")
	public String getUser(@PathVariable int id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "users/show";
	}

	@GetMapping("new")
	public String getUserNew(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "users/new";
	}

	@PostMapping
	public String postUserCreate(@ModelAttribute @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "users/new";
		}
		userService.addUser(user);
		return "redirect:/users";
	}

	@GetMapping("{id}/edit")
	public String getUserEdit(@PathVariable int id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return "users/edit";
	}

	@PutMapping("{id}")
	public String putUserEdit(@PathVariable int id, @ModelAttribute @Valid User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "users/edit";
		}
		user.setId(id);
		userService.updateUser(user);
		return "redirect:/users";
	}

	@DeleteMapping("{id}")
	public String deleteUser(@PathVariable int id, Model model) {
		userService.deleteUser(id);
		return "redirect:/users";
	}

}
