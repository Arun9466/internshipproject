package com.firststep.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.firststep.entity.Comments;

public interface CommentRepository extends JpaRepository<Comments, Integer>{

}
