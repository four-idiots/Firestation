package four_idiots.firestation.contoller;

import four_idiots.firestation.domain.dto.ResponseDto;
import four_idiots.firestation.domain.model.Firestation;
import four_idiots.firestation.domain.model.Member;
import four_idiots.firestation.domain.model.MemberList;
import four_idiots.firestation.sevice.FirestationService;
import four_idiots.firestation.sevice.MemberListService;
import four_idiots.firestation.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemberApiController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private FirestationService firestationService;

    @Autowired
    private MemberListService memberListService;

    @PostMapping("/auth/joinProc")
    public ResponseDto<Integer> userJoin(@RequestBody Member member) {
        memberService.memberJoin(member);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @PostMapping("/auth/FirejoinProc")
    public ResponseDto<Integer> firestationJoin(@RequestBody Firestation firestation) {
        firestationService.firestationJoin(firestation);
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @GetMapping("/memberList/{id}")
    public String getList(@PathVariable String id, Model model) {
        model.addAttribute("memberList", memberListService.userList(id));
        return "memberList";
    }
}
