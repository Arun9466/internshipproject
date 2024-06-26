package com.firststep.controller;


import java.sql.Blob;
import java.sql.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.firststep.dto.PostRequest;
import com.firststep.entity.Posts;
import com.firststep.service.PostService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/post")
public class PostController {
	@Autowired
	private PostService postService;
	
	@PostMapping("/{user_id}/postupload")
	public ResponseEntity<Posts> savePost(@PathVariable int user_id, 
			@RequestParam("content") MultipartFile content,
			@RequestParam("post_date") String postDate,
			@RequestParam("descr") String descr
			){
		PostRequest postRequest = new PostRequest();
		postRequest.setContent(content);
		postRequest.setPost_date(postDate);
		postRequest.setDescr(descr);
		postService.savePost(user_id,postRequest);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/getPosts")
	public ResponseEntity<List<Posts>> getAllPosts(){
		return ResponseEntity.ok(postService.getAllPosts());
	}
	
	@GetMapping("/{user_id}/getPost")
	public ResponseEntity<List<Posts>> getPost(@PathVariable int user_id){
		return ResponseEntity.ok(postService.getPost(user_id));
	}
	
	@DeleteMapping("/delete/{post_id}")
	public void deletePost(@PathVariable int post_id) {
		postService.deletePost(post_id);
	}
}
