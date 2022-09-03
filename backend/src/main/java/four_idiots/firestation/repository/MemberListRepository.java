package four_idiots.firestation.repository;

import four_idiots.firestation.domain.model.MemberList;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.criteria.CriteriaBuilder;

public interface MemberListRepository extends JpaRepository<MemberList, Integer> {

}
