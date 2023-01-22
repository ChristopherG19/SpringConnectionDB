package com.dbConnection.practiceB.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dbConnection.practiceB.entity.UserInsta;

@Repository("userInstaRepository")
public interface UserInstaRepository extends JpaRepository<UserInsta, Serializable>{

}
