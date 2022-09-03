package four_idiots.firestation.sevice;

import four_idiots.firestation.domain.model.Firestation;
import four_idiots.firestation.domain.model.RoleType;
import four_idiots.firestation.repository.FirestationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FirestationService {

    @Autowired
    private FirestationRepository firestationRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Transactional
    public void firestationJoin(Firestation firestation) {

        String rawPw = firestation.getFirestationPw();
        String encPw = encoder.encode(rawPw);
        firestation.setRoleType(RoleType.ADMIN);
        firestation.setFirestationPw(encPw);

        firestationRepository.save(firestation);
    }
}
