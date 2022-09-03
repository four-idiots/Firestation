package four_idiots.firestation.config.auth;

import four_idiots.firestation.domain.model.Firestation;
import four_idiots.firestation.domain.model.Member;
import four_idiots.firestation.repository.FirestationRepository;
import four_idiots.firestation.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class MemberDetailService implements UserDetailsService {

    @Autowired
    private FirestationRepository firestationRepository;

    @Override
    public UserDetails loadUserByUsername(String firestationname) throws UsernameNotFoundException {
        Firestation principal = firestationRepository.findByFirestationname(firestationname)
                .orElseThrow(()->{
                    return new UsernameNotFoundException("존재하지 않는 회원입니다.");
                });
        return new MemberDetail(principal);
    }
}
