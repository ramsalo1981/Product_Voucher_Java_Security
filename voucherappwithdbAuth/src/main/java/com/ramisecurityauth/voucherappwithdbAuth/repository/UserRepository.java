package com.ramisecurityauth.voucherappwithdbAuth.repository;

import com.ramisecurityauth.voucherappwithdbAuth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    User findByEmail(String email);
}
