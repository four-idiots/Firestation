package four_idiots.firestation.sevice;

import four_idiots.firestation.domain.model.Member;
import four_idiots.firestation.domain.model.RoleType;
import four_idiots.firestation.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    @Transactional
    public void memberJoin(Member member) {
//        member.setRoleType(RoleType.USER);
        memberRepository.save(member);
    }


    @Transactional(readOnly = true)
    public Page<Member> 회원목록(Pageable pageable) {
        return memberRepository.findAll(pageable);
    }
}
