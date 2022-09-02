package four_idiots.firestation.contoller;

import four_idiots.firestation.config.auth.MemberDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping({"","/"})
    public String index(@AuthenticationPrincipal MemberDetail member) {

        return "index";
    }
    @GetMapping("/auth/joinForm")
    public String joinForm() {

        return "Regist";
    }

    @GetMapping("/auth/loginForm")
    public String loginForm() {

        return "login";
    }
}
