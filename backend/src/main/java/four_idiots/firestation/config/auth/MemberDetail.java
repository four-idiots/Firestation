package four_idiots.firestation.config.auth;

import four_idiots.firestation.domain.model.Firestation;
import four_idiots.firestation.domain.model.Member;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class MemberDetail implements UserDetails {

    private Firestation firestation;

    public MemberDetail(Firestation firestation) {
        this.firestation = firestation;
    }

    @Override
    public String getPassword() {
        return firestation.getFirestationPw();
    }

    @Override
    public String getUsername() {
        return firestation.getFirestationname();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collectors = new ArrayList<>();

        collectors.add(()-> {
            return "ROLE_"+firestation.getRoleType();
        });
        return collectors;
    }
}
