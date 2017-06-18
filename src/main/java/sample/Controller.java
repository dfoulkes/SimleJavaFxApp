package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.com.foulkes.pojo.Role;
import sample.com.foulkes.pojo.RoleBuilder;
import sample.com.foulkes.pojo.User;
import sample.com.foulkes.pojo.UserBuilder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toList;

public class Controller {

    @FXML
    private Button loginBtn;
    @FXML
    private TextField usernameTextField;
    @FXML
    private TextField passwordTextField;

    private HashMap<Long, Role> roleHashMap = new HashMap<>();
    private Set<User> validUsers = new HashSet<>();

    public Controller() {
        generateRoles();
        generateUsers();
    }

    private void generateRoles(){
        roleHashMap.put(1L, RoleBuilder.getBuilder().withId(1L).withName("Student").build());
        roleHashMap.put(2L, RoleBuilder.getBuilder().withId(2L).withName("Teacher").build());
        roleHashMap.put(3L, RoleBuilder.getBuilder().withId(3L).withName("Admin").build());
    }

    private void generateUsers(){
        validUsers.add(UserBuilder.getBuilder()
                                    .withUsername("Dan")
                                    .withPassword("awesome")
                                    .withRole(roleHashMap.get(3L))
                                    .build());
        validUsers.add(UserBuilder.getBuilder()
                                    .withUsername("student")
                                    .withPassword("awesome")
                                    .withRole(roleHashMap.get(1L))
                                    .build());
        validUsers.add(UserBuilder.getBuilder()
                                    .withUsername("teacher")
                                    .withPassword("awesome")
                                    .withRole(roleHashMap.get(2L))
                                    .build());
    }

    public void submit(){
        System.out.println("Validating user"+  usernameTextField.getText());
        System.out.println("user details correct = "+   isValidUser(usernameTextField.getText(), passwordTextField.getText()));
    }

    private boolean isValidUser(String username, String password){
        return  validUsers.stream()
                .filter(x -> x.getUser().equals(username))
                .filter(y -> y.getPassword().equals(password))
                .collect(toList()).size() > 0? true : false;
    }
}
