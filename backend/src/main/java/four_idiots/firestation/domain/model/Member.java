package four_idiots.firestation.domain.model;


import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data // getter setter
@Builder
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,length = 30)
    private String apartname;

    @Column(nullable = false, length = 30)
    private String building; // 동

    @Column(nullable = false, length = 30)
    private String unit; // 호

    @Column(nullable = false, length = 15)
    private String phonenumber;

    @Column(nullable = false, length = 30)
    private String nearestStation;

//    @Enumerated(EnumType.STRING)
//    private RoleType roleType;

}
