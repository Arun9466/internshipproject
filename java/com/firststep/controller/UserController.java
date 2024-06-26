package com.firststep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.firststep.dto.LoginRequest;
import com.firststep.dto.ProfilePicDTO;
import com.firststep.dto.UserRequest;
import com.firststep.entity.UserProfile;
import com.firststep.service.LoginService;
import com.firststep.service.ProfilePictureService;
import com.firststep.service.UserService;

import jakarta.validation.Valid;


@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	 private UserService userService;
	@Autowired
	private LoginService loginService;
	@Autowired
	private ProfilePictureService profileService;
	@PostMapping("/signup")
	public ResponseEntity<UserProfile> saveUser(@RequestBody @Valid UserRequest userRequest){
		return new ResponseEntity<>(userService.saveUser(userRequest),HttpStatus.CREATED);
	}
	
	@GetMapping("/fetchAllUsers")
	public ResponseEntity<List<UserProfile>> getAllUser(){
		return ResponseEntity.ok(userService.getAllUsers());
	}
	
	@PostMapping("/login")
	public ResponseEntity<UserProfile> validateUser(@RequestBody @Valid LoginRequest loginRequest){
		return new ResponseEntity<>(loginService.loginUser(loginRequest),HttpStatus.ACCEPTED);
	}
	@PostMapping("/uploadPic/{user_id}")
	public ResponseEntity<UserProfile> savePic(@PathVariable int user_id, @RequestBody ProfilePicDTO profilePicDTO){
		profileService.savePicture(user_id, profilePicDTO);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	@GetMapping("/{user_id}/getUser")
	public ResponseEntity<UserProfile> getUserById(@PathVariable int user_id){
		return new ResponseEntity<>(userService.getUserById(user_id),HttpStatus.ACCEPTED);
	}
}	
