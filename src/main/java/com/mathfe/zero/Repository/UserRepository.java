package com.mathfe.zero.Repository;

import com.mathfe.zero.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
