package com.ramisecurityauth.voucherappwithdbAuth.Controller;

import com.ramisecurityauth.voucherappwithdbAuth.model.Voucher;
import com.ramisecurityauth.voucherappwithdbAuth.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/voucherapi")
public class VoucherRestController {

    @Autowired
   private VoucherRepository repository;

    @GetMapping("/vouchers")
    public List<Voucher> getVouchers(){
        return repository.findAll();
    }

    @GetMapping("/vouchers/{code}")
    public Voucher getVoucher(@PathVariable("code") String code ){
        return repository.findByCode(code);
    }

    @PostMapping("/vouchers")
    public Voucher createVoucher(@RequestBody Voucher voucher){
        return repository.save(voucher);
    }
}
