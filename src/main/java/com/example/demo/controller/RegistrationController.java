package com.example.demo.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import jakarta.servlet.http.HttpSession;


@Controller
public class RegistrationController {
	@Autowired
	UserRepository userRepository;
	
	 @GetMapping("/sign-up")
	    public String getup(Model model) {
			return "sign-up";
	    }
	
	
	
	
	
	
	
	@RequestMapping(path = "/sign-in", method = RequestMethod.GET)
	public String getlogin1() {
		return "sign-in";
	}

	@RequestMapping(path = "/sign-in", method = RequestMethod.POST)
	public String getlogin2(String ID, String NAME, String PW, Model model, HttpSession session) {
		
		List<User> userslist = userRepository.findAll();
		model.addAttribute("userslist", userslist);
		
		boolean userFound = false;
        for (User user : userslist) {
            if (user.getId().equals(ID) && user.getPassword().equals(PW)) {
            	session.setAttribute("username", user.getName());
                userFound = true;
                break;
            }
        }

        // 4. 一致するユーザーが見つかった場合、ログインを許可
        if (userFound) {

            return "redirect:/home";
        } else {
            return "redirect:/false";
        }
	}

	@RequestMapping(path = "/false", method = RequestMethod.GET)
	public String homefalse() {

		return "false";
	}

	 
	 
	 
	 
	 
	 
	 
	 
	 
}
