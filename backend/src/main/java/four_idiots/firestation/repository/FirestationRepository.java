package four_idiots.firestation.repository;

import four_idiots.firestation.domain.model.Firestation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FirestationRepository extends JpaRepository<Firestation, Integer> {
    Optional<Firestation> findByFirestationname(String firestationname);
}
