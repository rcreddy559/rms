package com.user.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import com.user.entity.UserEntity;

public interface UserRepositry extends JpaRepository<UserEntity, Long> {

} 
