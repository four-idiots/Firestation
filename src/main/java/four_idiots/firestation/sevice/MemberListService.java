package four_idiots.firestation.sevice;


import four_idiots.firestation.domain.model.MemberList;
import four_idiots.firestation.repository.MemberListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberListService {

    @Autowired
    private MemberListRepository memberListRepository;

    @Transactional(readOnly = true)
    public List<MemberList> userList() {
        return memberListRepository.findAll();
    }
}
