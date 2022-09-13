package four_idiots.firestation.domain.model;


import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Firestation {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30)
    private String firestationname;
    @Column(nullable = false, length = 100)
    private String firestationPw;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    @OneToMany(mappedBy = "firestation")
    private List<Member> members = new ArrayList<>();

}



