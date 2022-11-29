package com.AppBackend.Users.Repository;

import com.AppBackend.Users.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {


}
