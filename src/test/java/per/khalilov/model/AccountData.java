package per.khalilov.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountData {
    private String username;
    private String password;

    public AccountData(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
