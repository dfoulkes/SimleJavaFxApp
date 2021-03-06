package sample.com.foulkes.pojo;

import java.util.List;
import java.util.Set;

/**
 * Created by danfoulkes on 18/06/2017.
 * Project: SampleApp
 * Package: sample.com.foulkes.pojo
 */
public class User {
    private String user;
    private String password;
    private Set<Role> roles;

    public User(String user, String password, Set<Role> roles) {
        this.user = user;
        this.password = password;
        this.roles = roles;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    /*
    * override these methods to ensure that set we
    * use in the controller is able to determine they are unique.
     */
    @Override
    public int hashCode(){
        return user.hashCode();
    }

    @Override
    public boolean equals(Object o){
        if(o instanceof User){
            return getUser().equals(((User) o).getUser());
        }
        return false;
    }
}
