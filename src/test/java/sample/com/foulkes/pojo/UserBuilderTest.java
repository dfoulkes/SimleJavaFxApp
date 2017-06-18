package sample.com.foulkes.pojo;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by danfoulkes on 18/06/2017.
 * Project: SampleApp
 * Package: sample.com.foulkes.pojo
 */
public class UserBuilderTest {




    public static final String NAME = "name";
    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";


    Role role;

    @Before
    public void setup(){
        role = RoleBuilder.getBuilder().withName(NAME).withId(1L).build();
    }


    @Test
    public void shouldOnlyAddARoleOnce(){

        User user =  UserBuilder.getBuilder()
                .withPassword(PASSWORD)
                .withUsername(USERNAME)
                .withRole(role)
                .withRole(role)
                .build();

        assertThat(user.getRoles().size(), is(1));
    }

    @Test
    public void shouldBuildUser(){

       User user =  UserBuilder.getBuilder()
                        .withPassword(PASSWORD)
                        .withUsername(USERNAME)
                        .withRole(role)
                        .build();
        assertThat(user.getUser(), is(USERNAME));
        assertThat(user.getPassword(), is(PASSWORD));
    }

}