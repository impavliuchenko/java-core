package lombok_examples;

import java.util.Date;
import lombok.*;


@Data //getters, setters, AllArgsConstructor, NoArgsConstructor
//@Getter
//@Setter
@Builder //can build our instance - see UserService .builder(), but cancelling AllArgsConstructor, NoArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User{
    private Long id;
    private String username;
    private String password;
    private String name;
    private String nickName;
    private Date dateBirthday;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}
