package four_idiots.firestation.contoller;

import four_idiots.firestation.domain.dto.ResponseDto;
import four_idiots.firestation.domain.model.Firestation;
import four_idiots.firestation.domain.model.Member;
import four_idiots.firestation.sevice.FirestationService;
import four_idiots.firestation.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

//@Controller
@RestController
public class MemberApiController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private FirestationService firestationService;


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
        model.addAttribute("memberList", firestationService.userList(id));
        return "memberList";
    }

//    @GetMapping("/auth/memberList")
//    public String getList(Model model, @PageableDefault(size=3, sort = "id", direction = Sort.Direction.DESC) Pageable pageable) {
////        Member m1 = new Member(1, "가", "101", "231", "010-2341-2131", "C");
////        List<Member> memList = new ArrayList<>()
//        model.addAttribute("memberList", memberService.회원목록(pageable));
//        return "List";
//    }
}
