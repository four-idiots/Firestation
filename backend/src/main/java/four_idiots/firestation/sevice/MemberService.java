package four_idiots.firestation.sevice;

import four_idiots.firestation.domain.model.Member;
import four_idiots.firestation.domain.model.RoleType;
import four_idiots.firestation.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;


    @Transactional
    public void memberJoin(Member member) {
        member.setRoleType(RoleType.USER);
        memberRepository.save(member);
    }

}
