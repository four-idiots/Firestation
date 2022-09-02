package four_idiots.firestation.domain.model;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
public class Firestation {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 30)
    private String firestationname;

    @Column(nullable = false, length = 30)
    private String firestationPw;

    @Enumerated(EnumType.STRING)
    private RoleType roleType;

}
