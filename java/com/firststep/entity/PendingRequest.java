package com.firststep.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
@Entity
@Table(name = "pending_request")
public class PendingRequest {
	@Id
	@GeneratedValue
	private int pending_id;
	private int userId;
	private int requestedUser_id;
	
	
	

}
