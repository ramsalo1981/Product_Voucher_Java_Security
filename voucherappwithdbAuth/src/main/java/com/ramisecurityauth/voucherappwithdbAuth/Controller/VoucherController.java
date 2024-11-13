package com.ramisecurityauth.voucherappwithdbAuth.Controller;


import com.ramisecurityauth.voucherappwithdbAuth.model.Voucher;
import com.ramisecurityauth.voucherappwithdbAuth.repository.VoucherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class VoucherController {
    @Autowired
    VoucherRepository repository;

    @GetMapping("/showCreateVoucher")
    public String showCreateVoucher(){
        return "createVoucher";
    }

    @PostMapping("/saveVoucher")
    public  String save(Voucher voucher){
        repository.save(voucher);
        return "createResponse";
    }

    @GetMapping("/showGetVoucher")
    public String showGetVoucher(){
        return "getVoucher";
    }

    @PostMapping("/getVoucher")
    public ModelAndView getVoucher(String code)
    {
        ModelAndView mav = new ModelAndView("VoucherDetails");
        System.out.println(code);
        mav.addObject(repository.findByCode(code));
        return mav;
    }
}
