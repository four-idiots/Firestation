package four_idiots.firestation.contoller;

import four_idiots.firestation.config.auth.MemberDetail;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MemberController {

    @GetMapping({"", "/"})
    public String index () {
        return "index.html";
    }

    @GetMapping("/user/register")
    public String userRegister() {
        return "index.html";
    }

    @GetMapping("/admin/register")
    public String adminRegister() {
        return "index.html";
    }

    @GetMapping("/auth/loginForm")
    public String login() {
        return "loginForm";
    }
}


//    @GetMapping({"","/"})
//    public String index(@AuthenticationPrincipal MemberDetail member) {
//
//        return "index";
//    }