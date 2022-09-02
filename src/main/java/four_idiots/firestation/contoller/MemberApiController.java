package four_idiots.firestation.contoller;

import four_idiots.firestation.domain.dto.ResponseDto;
import four_idiots.firestation.domain.model.Firestation;
import four_idiots.firestation.domain.model.Member;
import four_idiots.firestation.sevice.FirestationService;
import four_idiots.firestation.sevice.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
