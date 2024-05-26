package com.example.phone_assia_jee.dao.repositories;

import com.example.phone_assia_jee.dao.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


}
