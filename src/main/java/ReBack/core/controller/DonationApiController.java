package ReBack.core.controller;

import ReBack.core.data.ClothingSponsor;
import ReBack.core.data.FinancialSupport;
import ReBack.core.repository.ClothingSponsorRepository;
import ReBack.core.repository.FinancialSupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class DonationApiController {

    @Autowired
    ClothingSponsorRepository clothingSponsorRepository;
    @Autowired
    FinancialSupportRepository financialSupportRepository;

    @PostMapping("/donation/clothingSponsor") //의류 후원
    public String clothingSponsor(@RequestBody ClothingSponsor clothingSponsor){
        clothingSponsorRepository.save(clothingSponsor);

        return "donation/clothingSponsor";
    }
    @PostMapping("/donation/FinancialSupport") //금전 후원
    public String FinancialSupport(@RequestBody FinancialSupport financialSupport){
        financialSupportRepository.save(financialSupport);

        return "donation/financialSupport";
    }
}
