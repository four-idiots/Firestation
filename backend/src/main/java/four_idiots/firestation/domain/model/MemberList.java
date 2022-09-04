package four_idiots.firestation.domain.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class MemberList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="apartname",referencedColumnName = "apartname"),
            @JoinColumn(name="building", referencedColumnName = "building"),
            @JoinColumn(name="unit", referencedColumnName = "unit"),
            @JoinColumn(name="phonenumber", referencedColumnName = "phonenumber"),
            @JoinColumn(name="nearestStation",referencedColumnName = "nearestStation")
    })
    private Member member;

    @OneToMany
    @JoinColumn(name="firestationname")
    private List<Firestation> firestation;

}
