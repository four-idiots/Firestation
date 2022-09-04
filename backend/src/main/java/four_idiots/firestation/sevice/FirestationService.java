package four_idiots.firestation.sevice;

import four_idiots.firestation.config.jwt.JwtTokenProvider;
import four_idiots.firestation.domain.dto.LoginRequestDto;
import four_idiots.firestation.domain.model.Firestation;
import four_idiots.firestation.domain.model.RoleType;
import four_idiots.firestation.repository.FirestationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class FirestationService {

    @Autowired
    private FirestationRepository firestationRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    private final JwtTokenProvider jwtTokenProvider;

    @Transactional
    public void firestationJoin(Firestation firestation) {

        String rawPw = firestation.getFirestationPw();
        String encPw = encoder.encode(rawPw);
        firestation.setRoleType(RoleType.ADMIN);
        firestation.setFirestationPw(encPw);

        firestationRepository.save(firestation);
    }

    public String login(LoginRequestDto loginRequestDto) {
        Firestation firestation = firestationRepository.findByFirestationname(loginRequestDto.getFirestationname())
                .orElseThrow(() -> new IllegalArgumentException(loginRequestDto.getFirestationname()));

        return jwtTokenProvider.createToken(firestation.getFirestationname(), firestation.getRoleType());
    }
}
