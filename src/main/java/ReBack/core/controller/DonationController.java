package ReBack.core.controller;

import ReBack.core.repository.ClothingSponsorRepository;
import ReBack.core.repository.FinancialSupportRepository;
import ReBack.core.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DonationController {

    @Autowired
    ClothingSponsorRepository clothingSponsorRepository;
    @Autowired
    FinancialSupportRepository financialSupportRepository;
    @Autowired
    MemberRepository memberRepository;
    @GetMapping("/donation") // 후원 메인
    public String donation() {

        return "donation/donationMain";
    }

    @GetMapping("/donation/selectForm") // 후원 종류 선택
    public String selectForm() {

        return "donation/donationSelectForm";
    }
    @GetMapping("/donation/financialSupport") //금전 후원
    public String financialSupport(){

        return "donation/financialSupport";
    }
    @GetMapping("/donation/clothingSponsor") //의류 후원
    public String clothingSponsor(){

        return "donation/clothingSponsor";
    }
    @GetMapping("/donation/applicationSituation") // 후원 현황
    public String applicationSituation(Model model){
        model.addAttribute("clothes" ,clothingSponsorRepository.findAll());
        model.addAttribute("member" ,memberRepository.findAll());
        model.addAttribute("financials" ,financialSupportRepository.findAll());
        return "donation/applicationSituation";
    }

}
