package com.firststep.service;

import java.sql.Blob;
import java.sql.Date;
import java.util.Base64;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firststep.dto.PostRequest;
import com.firststep.entity.Posts;
import com.firststep.repo.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	
	//save post
	public Posts savePost(int user_id,PostRequest postRequest) {
		try {
		Posts post = new Posts();
		post.setUser_id(user_id);
		Blob blob = new SerialBlob(postRequest.getContent().getBytes());
        post.setContent(blob);
        
        // Calculate and save base64Content
        if (blob != null) {
            int blobLength = (int) blob.length();
            byte[] blobContent = blob.getBytes(1, blobLength);
            String base64Content = Base64.getEncoder().encodeToString(blobContent);
            post.setBase64Content(base64Content);
        }
        post.setDescr(postRequest.getDescr());
		post.setPost_date(postRequest.getPost_date());
		return postRepository.save(post);
		}catch (Exception e) {
			throw new RuntimeException("Failed to upload post");
		}
	}
	
	//get all posts
	public List<Posts> getAllPosts(){
		return postRepository.findAll();
	}
	
	public List<Posts> getPost(int user_id){
		List<Posts> posts = postRepository.findByUser_id(user_id);
        for (Posts post : posts) {
        	try {
                Blob blob = post.getContent();
                if (blob != null) {
                    int blobLength = (int) blob.length();
                    byte[] blobContent = blob.getBytes(1, blobLength);
                    String base64Content = Base64.getEncoder().encodeToString(blobContent);
                    post.setBase64Content(base64Content);
                }
            } catch (Exception e) {
                throw new RuntimeException("Failed to process post content");
            }
        }
        return posts;
	}
	
	public void deletePost(int post_id) {
		postRepository.deleteById(post_id);
	}
	
}
