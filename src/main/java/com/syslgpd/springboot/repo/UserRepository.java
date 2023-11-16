package com.syslgpd.springboot.repo;

import com.syslgpd.springboot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends  JpaRepository<User,Integer>{

}
