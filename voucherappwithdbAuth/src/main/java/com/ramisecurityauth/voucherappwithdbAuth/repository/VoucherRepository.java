package com.ramisecurityauth.voucherappwithdbAuth.repository;

import com.ramisecurityauth.voucherappwithdbAuth.model.Voucher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<Voucher,Long> {
    Voucher findByCode(String code);
}
