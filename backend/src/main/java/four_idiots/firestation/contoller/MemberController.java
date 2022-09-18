package four_idiots.firestation.contoller;

import four_idiots.firestation.config.auth.MemberDetail;
import four_idiots.firestation.sevice.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MemberController {
    @Autowired
    private FirestationService firestationService;

    @GetMapping({"", "/"})
    public String index () {
        return "index.html";
    }

    @GetMapping("/user/register")
    public String userRegister() {
        return "/static/index.html";
    }

    @GetMapping("/admin/register")
    public String adminRegister() {
        return "admin.html";
    }

    @GetMapping("/auth/loginForm")
    public String login() {
        return "loginForm";
    }

    @GetMapping("/admin/memberList")
    public String getList(Model model) {
        model.addAttribute("memberList", firestationService.userList());
        return "memberList";
    }
}
