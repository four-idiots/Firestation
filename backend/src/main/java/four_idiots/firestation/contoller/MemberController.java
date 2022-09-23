package four_idiots.firestation.contoller;

import four_idiots.firestation.config.auth.MemberDetail;
import four_idiots.firestation.repository.MemberRepository;
import four_idiots.firestation.sevice.FirestationService;
import four_idiots.firestation.sevice.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class MemberController {

    @Autowired
    private FirestationService firestationService;

    @Autowired
    private MemberService memberService;

    @GetMapping({"", "/"})
    public String index () {
        return "index";
    }

    @GetMapping("/firestation/memberList")
    public String getList(Model model, HttpSession session) {

        model.addAttribute("memberList", firestationService.userList());
//        System.out.println(session.getId());
//        log.info(session.getId());

        return "memberList.html";

    }

    @GetMapping("/firestation/{phoneNum}")
    public String pushAlram(@PathVariable String phoneNum, Model model) {

        model.addAttribute("member", memberService.findMemberByPhoneNum(phoneNum));

        return "fireAlarm.html";
    }

    @GetMapping("/firestation/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "index";
    }
}
