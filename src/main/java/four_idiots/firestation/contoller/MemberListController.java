package four_idiots.firestation.contoller;

import four_idiots.firestation.repository.MemberListRepository;
import four_idiots.firestation.sevice.MemberListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public class MemberListController {

    @Autowired
    private MemberListService memberListService;

    @GetMapping({"","/"})
    public String index(Model model) {
        model.addAttribute("memberList", memberListService.userList());
        return "index";
    }

}
