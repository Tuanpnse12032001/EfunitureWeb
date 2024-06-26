package models.Enum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.example.securityl.models.Enum.Permission.*;


@RequiredArgsConstructor
public enum Role {
    USER(
            Set.of(
            USER_VIEW,
            USER_CREATE,
            USER_UPDATE,
            USER_DELETE

            )
    ),
    DESIGNER(
            Set.of(
                    DESIGNER_VIEW,
                    DESIGNER_CREATE,
                    DESIGNER_UPDATE,
                    DESIGNER_DELETE

            )
    ),
    ADMIN(
            Set.of(
            ADMIN_VIEW,
            ADMIN_CREATE,
            ADMIN_UPDATE,
            ADMIN_DELETE,
            STAFF_VIEW,
            STAFF_CREATE,
            STAFF_UPDATE,
            STAFF_DELETE

            )
    ),
    STAFF(
            Set.of(
            STAFF_VIEW,
            STAFF_CREATE,
            STAFF_UPDATE,
            STAFF_DELETE
            )
    ),
    STAFF_DELIVERY(
            Set.of(
                    STAFF_DELIVERY_VIEW,
                    STAFF_DELIVERY_CREATE,
                    STAFF_DELIVERY_UPDATE,
                    STAFF_DELIVERY_DELETE
            )
    );
//    ,
//    DESIGNER(
//            Set.of(
//                    DESIGNER_VIEW,
//                    DESIGNER_CREATE,
//                    DESIGNER_UPDATE,
//                    DESIGNER_DELETE
//            )
//    );



    @Getter
    private final Set<Permission> permissions;

    public List<SimpleGrantedAuthority> getAuthorities(){
        var authorities = getPermissions()
                .stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPerminssion()))
                .collect(Collectors.toList());
        authorities.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
        return authorities;
    }
}
