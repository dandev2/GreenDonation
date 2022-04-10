package ReBack.core.controller;

import ReBack.core.repository.LectureRepository;
import ReBack.core.repository.MemberRepository;
import ReBack.core.repository.WriterInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@org.springframework.stereotype.Controller
public class EducationController {

    @Autowired
    WriterInformationRepository writerInformationRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    LectureRepository lectureRepository;

    @GetMapping("/education")
    public String education() {return "/education/education";}

    @GetMapping("/education/fitedu")
    public String fitedu() {return "/education/fitedu";}

    @GetMapping("/education/shareedu")
    public String shareedu(Model model) {
//        System.out.println(model.addAttribute("info", writerInformationRepository.findAll()) + "찍히나 ?");
        model.addAttribute("info", writerInformationRepository.findAll());

        return "/education/shareedu";}

    @GetMapping("/education/shareedu/writerResult/{memberCode}")
    public String writerResult(@PathVariable Long memberCode, Model model){
        model.addAttribute("member", memberRepository.findByMemberCode(memberCode));
        model.addAttribute("info2", writerInformationRepository.findAll());
        model.addAttribute("lecture", lectureRepository.findAll());
        return "/education/writerResult";
    }
}
