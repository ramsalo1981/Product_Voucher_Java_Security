package com.ramisecurityauth.voucherappwithdbAuth.repository;

import com.ramisecurityauth.voucherappwithdbAuth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
