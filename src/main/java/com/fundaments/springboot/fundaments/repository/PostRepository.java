package com.fundaments.springboot.fundaments.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
//entidad
import com.fundaments.springboot.fundaments.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {

}
