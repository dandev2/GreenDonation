package ReBack.core.controller;

import ReBack.core.repository.DesignRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DesignController {
    @Autowired
    DesignRepository designRepository;

    @GetMapping("/design/addpost")
    public String designAddPost() {
        return "/design/addpost";
    }

    @GetMapping("/design/matching")
    public String designMatching() {
        return "/design/matching";
    }

    @GetMapping("/design/list")
    public String designList(Model model) {
        model.addAttribute("Design", designRepository.findAll());
        System.out.println("designRepository.findAll() = " + designRepository.findAll());
        return "/design/list";
    }

    @GetMapping("/design/list/{designid}")
    public String designListDetails(@PathVariable("designid") Long designid, Model model) {
        model.addAttribute("design", designRepository.findById(designid).get());
        return "/design/listDetails";
    }

}
