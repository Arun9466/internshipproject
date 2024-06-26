package com.firststep.service;

import java.sql.Blob;
import java.util.Base64;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.firststep.dto.ProfilePicDTO;
import com.firststep.entity.UserProfile;
import com.firststep.repo.UserRepository;

@Service
public class ProfilePictureService {
	@Autowired
	private UserRepository userRepository;
	
	public UserProfile savePicture(int user_id,ProfilePicDTO profilePic) {
		try {
			UserProfile user = userRepository.findById(user_id).orElse(null);
			Blob blob = new SerialBlob(profilePic.getPicture().getBytes());
			if(blob!=null) {
			int blobLength =(int)blob.length();
			 byte[] blobContent = blob.getBytes(1, blobLength);
	            String base64Content = Base64.getEncoder().encodeToString(blobContent);
	            user.setPicture(base64Content);
			}
	            return userRepository.save(user);
			
		} catch (Exception e) {
			throw new RuntimeException("Failed to upload ProfilePic");
		}
	}
}
