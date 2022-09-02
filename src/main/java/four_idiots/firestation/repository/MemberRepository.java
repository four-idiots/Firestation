package four_idiots.firestation.repository;

import four_idiots.firestation.domain.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
