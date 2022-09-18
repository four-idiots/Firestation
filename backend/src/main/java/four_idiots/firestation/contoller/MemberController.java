package four_idiots.firestation.contoller;

import four_idiots.firestation.config.auth.MemberDetail;
import four_idiots.firestation.sevice.FirestationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private FirestationService firestationService;

    @GetMapping({"", "/"})
    public String index () {
        return "index";
    }

//    @GetMapping("/user/register")
//    public String userRegister() {
//        return "admin.html";
//    }

//    @GetMapping("/admin/register")
//    public String adminRegister() {
//        return "admin.html";
//    }

//    @GetMapping("/auth/loginForm")
//    public String login() {
//        return "index";
//    }

    @GetMapping("/firestation/memberList")
    public String getList(Model model, HttpSession session) {

        model.addAttribute("memberList", firestationService.userList());
        System.out.println(session.getId());
        log.info(session.getId());

        return "memberList.html";

    }
}
