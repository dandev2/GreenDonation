package ReBack.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {
    @GetMapping("/member")
    public String index() {
        return "member";
    }

    @GetMapping("/member/login")
    public String login() {
        return "member/signIn";

    }
    @GetMapping("/member/signupType")
    public String memberSignupType() {

        return "member/signupType";
    }
    @GetMapping("/member/generalSignup")
    public String generalSignup() {

        return "member/memberSignUp";
    }


}
